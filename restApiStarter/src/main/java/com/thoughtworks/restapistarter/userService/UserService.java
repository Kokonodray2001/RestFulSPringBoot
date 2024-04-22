package com.thoughtworks.restapistarter.userService;

import com.thoughtworks.restapistarter.ui.model.request.UserDetailsRequestModel;
import com.thoughtworks.restapistarter.ui.model.response.UserRest;

public interface UserService {
    public UserRest createUser(UserDetailsRequestModel userDetails);
}
