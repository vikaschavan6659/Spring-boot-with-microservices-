package com.vikas.user.service.service;

import com.vikas.user.service.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    // user operation
    // create

    User saveUser( User user);

    // get all user

    List<User> getAllUser();

    // get single user

    User getUser(Long userId);

    // delete single  user

    User deleteAllUser( Long userId);

    // update user by it userid

    ResponseEntity<User> updateUser(Long userId);

}
