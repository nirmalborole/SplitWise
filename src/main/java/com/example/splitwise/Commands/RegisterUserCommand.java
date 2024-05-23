package com.example.splitwise.Commands;

import com.example.splitwise.Exceptions.InvalideCommandExceptions;
import com.example.splitwise.controller.UserController;
import com.example.splitwise.dtos.RegisterUserRequestDto;
import com.example.splitwise.dtos.RegisterUserResponseDto;
import com.example.splitwise.dtos.ResponseType;
import com.example.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{
    private UserController userController;
    private static  final String REGISTER_USER_KEY="Register";

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
        CommandRegistry.getInstance().addCommand(REGISTER_USER_KEY,this);
    }

    @Override
    public void execute(String input) throws InvalideCommandExceptions {
        String[] s = input.split(" ");
        if(s.length != 4){
            throw new InvalideCommandExceptions("Given command not valide & not corrent format");
        }
        RegisterUserRequestDto requestDto=new RegisterUserRequestDto();
        requestDto.setUserName(s[1]);
        requestDto.setPassword(s[3]);
        requestDto.setPhoneNumber(s[2]);
        RegisterUserResponseDto responseDto = userController.registerUser(requestDto);
        if(responseDto.getResponse().getType().equals(ResponseType.FAILUARE)){
            System.out.println("Err:" + responseDto.getResponse().getErrorMessage());
        }else{
            System.out.println("User: "+ responseDto.getUser());
        }
    }
}
