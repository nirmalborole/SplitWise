package com.example.splitwise;

import com.example.splitwise.Commands.Command;
import com.example.splitwise.Commands.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("Awaiting for input");
            String input=sc.nextLine();
            try {
                Command command = CommandRegistry.getInstance().getCommand(input);
                command.execute(input);
            }catch (Exception e){
                System.out.println("somenthing go wroung, pleasse reenter the input" + e.getMessage());
            }
        }
    }
}
