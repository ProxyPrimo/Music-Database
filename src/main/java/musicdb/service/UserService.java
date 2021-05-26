package musicdb.service;

import musicdb.data.entity.UserEntity;
import musicdb.data.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String addedFromUsername);
}
