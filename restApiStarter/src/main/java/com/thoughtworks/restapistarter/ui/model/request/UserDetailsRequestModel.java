package com.thoughtworks.restapistarter.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDetailsRequestModel {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "firstName can't be Null")
    private String firstName;

    @NotNull(message = "lastName can't be Null")
    private String lastName;

    @NotNull(message = "email can't be Null")
    @Email
    private String email;

    @NotNull(message = "userId can't be Null")
    private String userId;

    @NotNull(message = "password can't be Null")
    @Size(min = 8 , max = 16 , message = "password should be greater than or equal to 8 and less than equal to 16")
    private String password;
}
