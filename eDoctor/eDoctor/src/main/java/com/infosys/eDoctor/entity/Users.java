package com.infosys.eDoctor.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Users {

    @Id
    private String email;
    private String name;
    private String password;
    private String userType;

    public Users() {
    }

    public Users(String email, String name, String password, String userType) {
        super();
        this.email = email;
        this.name = name;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }


    //Encryption of Password
//    public void setPassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        this.password = encoder.encode(password);
//    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}