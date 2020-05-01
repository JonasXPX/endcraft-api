package br.com.endcraft.endcraftapi.archive.web;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.Version;
import br.com.endcraft.endcraftapi.archive.service.ArchiveService;
import br.com.endcraft.endcraftapi.archive.service.VersionService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("archive")
@AllArgsConstructor
public class ArchiveController {

    private ArchiveService archiveService;
    private VersionService versionService;

    @GetMapping("{code}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String code, Version version) {
        Archive archive = archiveService.findArchiveByCode(code);
        ByteArrayResource file = archiveService.getFileFromHomeDirectory(archive, version);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + version.getFileName())
                .body(file);
    }

    @GetMapping("/versions/{code}")
    public ResponseEntity<Page<Version>> findFileVersion(@PathVariable String code, Pageable pageable) {
        Archive archive = archiveService.findArchiveByCode(code);
        return ResponseEntity.ok(versionService.findVersionsByArchive(archive, pageable));
    }

}
