package bg.softUni.ShopingList.service;

import bg.softUni.ShopingList.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
