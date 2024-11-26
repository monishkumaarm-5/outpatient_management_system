package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Users;
import com.infosys.eDoctor.reposatory.UsersRepo;
import com.infosys.eDoctor.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;

    //Encrpytion of Password
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users addUser(Users user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }


//    public Boolean loginUser(LoginRequest loginRequest) {
//
//        Optional<Users> user = usersRepo.findById(loginRequest.getUserId());
//        Users user1 = user.get();
//
//        if(user1 == null) {
//            return false;
//        }
//
//        if(!user1.getPassword().equals(loginRequest.getPassword())) {
//            return false;
//        }
//
//        //change
//        if (!user1.getUserType().equals(loginRequest.getUserType())) {
//            return false;
//        }
//
//        return true;
//    }


    //Encryption of Password
    public Boolean loginUser(LoginRequest loginRequest) {
        Optional<Users> userOptional = usersRepo.findByEmail(loginRequest.getUserId());
        if (!userOptional.isEmpty()) {
            return false;
        }

        Users existingUser = userOptional.get();

        // Check if password matches and user type is correct
        boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), existingUser.getPassword());
        boolean userTypeMatches = existingUser.getUserType().equals(loginRequest.getUserType());

        return passwordMatches && userTypeMatches;
    }

}

