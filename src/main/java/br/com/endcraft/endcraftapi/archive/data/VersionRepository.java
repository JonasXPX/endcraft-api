package br.com.endcraft.endcraftapi.archive.data;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.Version;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends CrudRepository<Version, Long> {

    Page<Version> findVersionsByArchiveIs(Archive archive, Pageable pageable);
}