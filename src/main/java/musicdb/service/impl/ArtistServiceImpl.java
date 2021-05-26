package musicdb.service.impl;

import musicdb.data.entity.ArtistEntity;
import musicdb.data.entity.enumeration.ArtistName;
import musicdb.repository.ArtistRepository;
import musicdb.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initArtists() {
        if (artistRepository.count() == 0) {
            Arrays.stream(ArtistName.values())
                    .forEach(a -> {
                        ArtistEntity artistEntity =
                                new ArtistEntity(a, "A description for " + a);

                        artistRepository.saveAndFlush(artistEntity);
                    });
        }
    }

    @Override
    public ArtistEntity findArtistByArtistName(ArtistName artist) {
        return this.artistRepository.findByName(artist);
    }
}
