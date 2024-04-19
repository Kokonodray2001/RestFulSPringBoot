package com.thoughtworks.restapistarter.ui.controller;

import com.thoughtworks.restapistarter.ui.model.response.UserRest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users") // http://localhost:8081/users
public class UserController {
    private final HttpSession httpSession;

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
        UserRest user = new UserRest();
        user.setEmail("kokonodray2001@gmail.com");
        user.setFirstName("Kokonod");
        user.setLastName("Ray");
        user.setUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
