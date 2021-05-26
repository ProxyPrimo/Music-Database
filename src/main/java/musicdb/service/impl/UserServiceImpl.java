package musicdb.service.impl;

import musicdb.data.entity.UserEntity;
import musicdb.data.service.UserServiceModel;
import musicdb.repository.UserRepository;
import musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
        implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        this.userRepository
                .saveAndFlush(
                        this.modelMapper
                                .map(userServiceModel, UserEntity.class)
                );
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = this.userRepository.findByUsernameAndPassword(username, password);
        return userEntity == null ? null : modelMapper.map(userEntity, UserServiceModel.class);
    }
}
