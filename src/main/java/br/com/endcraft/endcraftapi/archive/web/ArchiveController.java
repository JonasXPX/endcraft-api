package br.com.endcraft.endcraftapi.archive.web;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.service.ArchiveService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("archive")
@AllArgsConstructor
public class ArchiveController {

    private ArchiveService archiveService;

    @GetMapping("{code}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String code) {
        Archive archive = archiveService.findArchiveByCode(code);
        ByteArrayResource file = archiveService.getFileFromHomeDirectory(archive);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + archive.getFileName())
                .body(file);
    }
}
