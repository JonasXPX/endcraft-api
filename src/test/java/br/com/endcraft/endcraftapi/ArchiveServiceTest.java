package br.com.endcraft.endcraftapi;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.service.ArchiveService;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "classpath:/initial/database.xml")
@DatabaseTearDown("classpath:/tearDown/tearDown.xml")
class ArchiveServiceTest extends BaseService{

	@Autowired
	ArchiveService archiveService;

	@Test
	void shouldFindArchiveByCode() {
		Archive test = archiveService.findArchiveByCode("TEST");

		assertThat(test).isNotNull();
		assertThat(test.getId()).isEqualTo(99999L);
		assertThat(test.getFileVersions()).isNotEmpty();
	}

}
