package com.example.splitwise.repository;

import com.example.splitwise.Exceptions.ResisterUserException;
import com.example.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findUserByUserNameEqualsOrPhoneNumber(String username, String phoneNumber) throws ResisterUserException;

}
