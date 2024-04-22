package com.thoughtworks.restapistarter.ui.controller;

import com.thoughtworks.restapistarter.UserServiceImplementation;
import com.thoughtworks.restapistarter.exception.UserServiceException;
import com.thoughtworks.restapistarter.ui.model.request.UpdateUserDetailsRequestModel;
import com.thoughtworks.restapistarter.ui.model.request.UserDetailsRequestModel;
import com.thoughtworks.restapistarter.ui.model.response.UserRest;
import com.thoughtworks.restapistarter.userService.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("users") // http://localhost:8081/users
public class UserController {
    private final HttpSession httpSession;

    private Map<String,UserRest> users;

    @Autowired
    UserService userService;

    public UserController(HttpSession httpSession) {
        this.httpSession = httpSession;
    } // controller for user only

    @GetMapping
    public String getUser(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit ,
                          @RequestParam(value = "name" , required = false) String name )
    {
        return "get user was called page " + page + " and limit " + limit + " and name " + name;
    }

    @GetMapping(path = "/{userId}" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

//      String firstName = null;
//      int len =  firstName.length(); // null pointer exception

       if(true) throw  new UserServiceException("A user service exception is thrown");

        if(users.containsKey(userId))
            return new ResponseEntity<>(users.get(userId) , HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser( @Valid @RequestBody UserDetailsRequestModel userDetails){

      //  UserServiceImplementation userService =  new UserServiceImplementation(); direct dependency can't be used while testing


        return new ResponseEntity<>(userService.createUser(userDetails),HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",  produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE},
    consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel updateDetails){
        if(!users.containsKey(userId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        UserRest user = users.get(userId);
        if(updateDetails.getEmail() != null)
            user.setEmail(updateDetails.getEmail());
        if(updateDetails.getFirstName() != null)
            user.setFirstName(updateDetails.getFirstName());
        if(updateDetails.getLastName() != null)
            user.setEmail(updateDetails.getLastName());

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
