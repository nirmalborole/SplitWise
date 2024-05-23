package com.example.splitwise.Commands;

import com.example.splitwise.Exceptions.InvalideCommandExceptions;

public interface Command {
     void execute(String input) throws InvalideCommandExceptions;
}
