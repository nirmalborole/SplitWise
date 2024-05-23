package com.example.splitwise.dtos;

import lombok.Data;

@Data
public class Response {
    private String errorMessage;
    private ResponseType type;

    public static  Response getSucessResponse(){
        Response response=new Response();
        response.setType(ResponseType.SUCCESS);
        return response;
    }
    public static  Response getFailureResponse(String errorMeassage){
        Response response=new Response();
        response.setType(ResponseType.FAILUARE);
        response.setErrorMessage(errorMeassage);
        return response;
    }
}
