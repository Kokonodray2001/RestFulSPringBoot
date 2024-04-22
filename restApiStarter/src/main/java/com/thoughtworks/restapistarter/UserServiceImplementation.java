package com.thoughtworks.restapistarter;

import com.thoughtworks.restapistarter.shared.Utils;
import com.thoughtworks.restapistarter.ui.model.request.UserDetailsRequestModel;
import com.thoughtworks.restapistarter.ui.model.response.UserRest;
import com.thoughtworks.restapistarter.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service // instance of this is available for autowiring to UserService
public class UserServiceImplementation implements UserService {
    HashMap<Object, Object> users;
    Utils utils;

    public UserServiceImplementation() {
    }
    @Autowired // CONSTRUCTOR INJECTION
    public UserServiceImplementation(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest newUser = new UserRest();
        newUser.setEmail(userDetails.getEmail());
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());
        newUser.setUserId(utils.generateUserId());
        newUser.setPassword(userDetails.getPassword());
        if(users ==  null) users = new HashMap<>();
        users.put(newUser.getUserId(),newUser);
        return newUser;
    }
}
