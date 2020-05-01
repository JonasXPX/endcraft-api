package br.com.endcraft.endcraftapi.archive.data;

import br.com.endcraft.endcraftapi.archive.Archive;
import br.com.endcraft.endcraftapi.archive.Version;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ArchiveRepository extends CrudRepository<Archive, Long> {

    Page<Archive> findAll(Pageable pageable);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "graph.archive")
    Archive findArchiveByCodeLike(String code);

    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE downloads SET download_times = download_times+1 WHERE id_archive = ?1")
    int updateDownloadTimes(Long id);

}
