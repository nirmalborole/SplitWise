package com.example.splitwise.dtos;

import com.example.splitwise.models.User;
import lombok.Data;

@Data
public class RegisterUserResponseDto {
    private User user;
    private Response response;

}
