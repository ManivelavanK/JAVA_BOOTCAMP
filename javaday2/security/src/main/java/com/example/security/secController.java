package com.example.security;

import  jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class secController {
    @GetMapping("")
    public String security() {
        return "Welcome to security class";
    }
}