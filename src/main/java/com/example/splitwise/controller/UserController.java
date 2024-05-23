package com.example.splitwise.controller;

import com.example.splitwise.Exceptions.InvalidRequestException;
import com.example.splitwise.dtos.RegisterUserRequestDto;
import com.example.splitwise.dtos.RegisterUserResponseDto;
import com.example.splitwise.dtos.Response;
import com.example.splitwise.models.User;
import com.example.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto){
        RegisterUserResponseDto registerUserResponseDto=new RegisterUserResponseDto();
        try{
            validateRequest(requestDto);
            User user = this.userService.registerUser(requestDto.getUserName(), requestDto.getPassword(), requestDto.getPhoneNumber());
            registerUserResponseDto.setUser(user);
            registerUserResponseDto.setResponse(Response.getSucessResponse());
        }catch (Exception e){
            registerUserResponseDto.setResponse(Response.getFailureResponse(e.getMessage()));
        }
        return registerUserResponseDto;
    }

    private void validateRequest(RegisterUserRequestDto requestDto) throws InvalidRequestException {
        if(requestDto.getUserName()== null || requestDto.getPassword()== null || requestDto.getPhoneNumber()==null){
            throw new InvalidRequestException("Usernae or password ar not valide");
        }
    }
}
