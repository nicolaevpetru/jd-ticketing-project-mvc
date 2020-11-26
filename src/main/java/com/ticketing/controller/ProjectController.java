package com.ticketing.controller;

import com.ticketing.dto.ProjectDTO;
import com.ticketing.service.ProjectService;
import com.ticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String projectCreate(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        //model.addAttribute("managers", userService.findAll());
        model.addAttribute("managers", userService.findAll().stream()
                .filter(user -> user.getRole().getDescription().equals("Manager"))
                .collect(Collectors.toList()));

        return "/project/create";
    }
}
