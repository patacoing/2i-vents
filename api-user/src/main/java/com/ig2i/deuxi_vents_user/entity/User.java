package com.ig2i.deuxi_vents_user.entity;

import com.ig2i.deuxi_vents_user.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document("users")
public class User implements UserDetails {
    @Id
    private String id;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", promo='" + promo + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    private String firstName;
    private String lastName;

    private String promo;

    private String password;

    private UserRole role;

    public User() {

    }

    public User(String firstName, String lastName, String promo, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.promo = promo;
        this.password = password;
    }

    public User(String id, String firstName, String lastName, String promo, String password, UserRole role) {
        super();
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

    public void setId(String id) {
        this.id = id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        System.out.println(firstName + " " + lastName);
        return firstName + " " + lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
