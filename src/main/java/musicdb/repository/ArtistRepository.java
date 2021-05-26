package musicdb.repository;

import musicdb.data.entity.ArtistEntity;
import musicdb.data.entity.enumeration.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    ArtistEntity findByName(ArtistName name);
}
