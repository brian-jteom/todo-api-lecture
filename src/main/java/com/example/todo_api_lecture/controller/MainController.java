package com.example.todo_api_lecture.controller;

import com.example.todo_api_lecture.entity.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String welcome() {
        return "Hello World";
    }

    @GetMapping(value = "/health/checker")
    public String healthChecker() {

        return "success";
    }
}
