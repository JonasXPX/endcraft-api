package br.com.endcraft.endcraftapi.archive.web;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.service.ArchiveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("archive")
@AllArgsConstructor
public class ArchiveController {

    private ArchiveService archiveService;

    @GetMapping("{code}")
    public Archive findArchiveByCode(@PathVariable String code) {
        return archiveService.findArchiveByCode(code);
    }
}
