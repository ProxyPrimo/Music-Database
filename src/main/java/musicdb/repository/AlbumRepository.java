package musicdb.repository;

import musicdb.data.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    @Query("select sum(a.copies) from AlbumEntity a")
    Integer getCopiesCount();
}
