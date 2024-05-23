package com.example.splitwise.services;

import com.example.splitwise.Exceptions.ResisterUserException;
import com.example.splitwise.models.User;

public interface UserService {
    public User registerUser(String userName, String password, String phoneNumber) throws ResisterUserException;
}
