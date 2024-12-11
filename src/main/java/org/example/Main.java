package org.example;

import org.example.Domain.Student;
import org.example.Domain.StudentValidator;
import org.example.Repository.Repository;
import org.example.Repository.StudentDbRepository;
import org.example.Service.StudentService;
import org.example.Userinterface.Console;

public class Main {
    public static void main(String[] args) {

        String username = "postgres";
        String pasword = "postgres";
        String url ="jdbc:postgresql://localhost:5432/socialnetwork4";
        Repository<Long, Student> studentdb =
                new StudentDbRepository(url, username, pasword, new StudentValidator());
        StudentService studentservice = new StudentService(studentdb, new StudentValidator());
        Console console = new Console(studentservice);
        console.start();
    }
}