package com.thoughtworks.restapistarter.ui.model.request;

import jakarta.validation.constraints.Email;

public class UpdateUserDetailsRequestModel {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String userId;

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


}
