package br.com.endcraft.endcraftapi;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.Version;
import br.com.endcraft.endcraftapi.archive.service.ArchiveService;
import br.com.endcraft.endcraftapi.archive.service.VersionService;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@DatabaseSetup("classpath:/initial/database.xml")
@DatabaseTearDown("classpath:/tearDown/tearDown.xml")
public class VersionServiceTest extends BaseService {

    @Autowired
    VersionService versionService;

    @Test
    void shouldFindVersionByArchive() {
        Archive archive = Archive.builder().id(99999L).build();
        Page<Version> versions = versionService.findVersionsByArchive(archive, Pageable.unpaged());
        assertThat(versions).isNotEmpty();
        assertThat(versions).hasSize(2);
    }

}
