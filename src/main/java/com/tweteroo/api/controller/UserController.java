package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    
    @PostMapping
    public void create(@RequestBody @Valid UserDTO req) {
        System.out.println(req);
    }
}
