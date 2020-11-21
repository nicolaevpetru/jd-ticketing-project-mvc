package com.ticketing.controller;

import com.ticketing.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/create", "/add", "/initialize"})
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        // TO DO
        // DataGenerator
        return "user/create";
    }
}
