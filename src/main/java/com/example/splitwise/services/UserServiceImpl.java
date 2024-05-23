package com.example.splitwise.services;

import com.example.splitwise.Exceptions.ResisterUserException;
import com.example.splitwise.models.User;
import com.example.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String userName, String password, String phoneNumber) throws ResisterUserException {
        Optional<User> existingUserCheack = this.userRepository.findUserByUserNameEqualsOrPhoneNumber(userName, phoneNumber);
        if(existingUserCheack.isPresent()){
            throw  new ResisterUserException("user already present in Db");
        }
        User user= new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        return this.userRepository.save(user);
    }
}
