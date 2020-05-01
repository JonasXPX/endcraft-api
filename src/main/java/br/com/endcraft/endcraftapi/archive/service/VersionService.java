package br.com.endcraft.endcraftapi.archive.service;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.Version;
import br.com.endcraft.endcraftapi.archive.data.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VersionService {

    final VersionRepository versionRepository;

    public Page<Version> findVersionsByArchive(Archive archive, Pageable pageable) {
        return versionRepository.findVersionsByArchiveIs(archive, pageable);
    }
}
