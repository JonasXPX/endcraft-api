package br.com.endcraft.endcraftapi.archive.data;

import br.com.endcraft.endcraftapi.archive.Archive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveRepository extends CrudRepository<Archive, Long> {

    Archive findArchiveByCodeLike(String code);
}
