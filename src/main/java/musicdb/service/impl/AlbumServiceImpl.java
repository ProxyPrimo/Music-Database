package musicdb.service.impl;

import musicdb.data.entity.AlbumEntity;
import musicdb.data.service.AlbumServiceModel;
import musicdb.data.view.AlbumViewModel;
import musicdb.repository.AlbumRepository;
import musicdb.service.AlbumService;
import musicdb.service.ArtistService;
import musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistService artistService, UserService userService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AlbumServiceModel albumServiceModel) {
        AlbumEntity albumEntity = modelMapper.map(albumServiceModel, AlbumEntity.class);
        albumEntity.setArtist(artistService.findArtistByArtistName(albumServiceModel.getArtist()));
        albumEntity.setAddedFrom(userService.findByUsername(albumServiceModel.getAddedFromUsername()));
        albumRepository.saveAndFlush(albumEntity);
    }

    @Override
    public List<AlbumViewModel> showAllAlbums() {
        return albumRepository.findAll().stream().map(a -> {
                    AlbumViewModel albumViewModel = modelMapper.map(a, AlbumViewModel.class);
                    albumViewModel.setArtist(a.getArtist().getName().name());
                    return albumViewModel;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Integer getCopiesCount() {
        return albumRepository.getCopiesCount();
    }
}
