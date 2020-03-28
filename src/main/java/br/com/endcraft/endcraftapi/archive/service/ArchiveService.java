package br.com.endcraft.endcraftapi.archive.service;

import br.com.endcraft.endcraftapi.archive.data.ArchiveRepository;
import br.com.endcraft.endcraftapi.archive.Archive;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ArchiveService {

    private ArchiveRepository archiveRepository;

    public Archive findArchiveByCode(String code) {
        return archiveRepository.findArchiveByCodeLike(code);
    }

}
