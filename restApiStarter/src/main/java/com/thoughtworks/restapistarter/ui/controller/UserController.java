package com.thoughtworks.restapistarter.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8081/users
public class UserController { // controller for user only

    @GetMapping
    public String getUser(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit)
    {
        return "get user was called page " + page + " and limit " + limit;
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
