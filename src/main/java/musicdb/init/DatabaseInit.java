package musicdb.init;

import musicdb.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ArtistService artistService;

    @Autowired
    public DatabaseInit(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        artistService.initArtists();
    }
}
