package musicdb.service;

import musicdb.data.service.AlbumServiceModel;
import musicdb.data.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void add(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> showAllAlbums();

    Integer getCopiesCount();
}
