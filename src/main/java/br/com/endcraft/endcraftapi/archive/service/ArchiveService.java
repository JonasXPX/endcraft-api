package br.com.endcraft.endcraftapi.archive.service;

import br.com.endcraft.endcraftapi.archive.Version;
import br.com.endcraft.endcraftapi.archive.data.ArchiveRepository;
import br.com.endcraft.endcraftapi.archive.Archive;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
@Service
public class ArchiveService {

    private ArchiveRepository archiveRepository;

    public Archive findArchiveByCode(String code) {
        return archiveRepository.findArchiveByCodeLike(code);
    }

    @SneakyThrows
    public ByteArrayResource getFileFromHomeDirectory(Archive archive, Version version) {
        String home = System.getProperty("user.home");
        Path path = Paths.get(home + "/" + version.getFileName());
        byte[] fileBytes = Files.readAllBytes(path);
        archiveRepository.updateDownloadTimes(archive.getId());
        return new ByteArrayResource(fileBytes);
    }
}
