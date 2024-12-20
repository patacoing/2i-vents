package com.ig2i.deuxi_vents_user.dto;

import java.util.UUID;

public class UserDto {

    private String id;

    private String firstName;

    private String lastName;

    private String promo;
    private String password;

    private String role;

    public UserDto(String id, String firstName, String lastName, String promo, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.promo = promo;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", promo='" + promo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
