package musicdb.service;

import musicdb.data.entity.ArtistEntity;
import musicdb.data.entity.enumeration.ArtistName;

public interface ArtistService {
    void initArtists();

    ArtistEntity findArtistByArtistName(ArtistName artist);
}
