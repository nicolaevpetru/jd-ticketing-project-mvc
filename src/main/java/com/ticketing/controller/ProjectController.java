package com.ticketing.controller;

import com.ticketing.dto.ProjectDTO;
import com.ticketing.dto.TaskDTO;
import com.ticketing.dto.UserDTO;
import com.ticketing.service.ProjectService;
import com.ticketing.service.TaskService;
import com.ticketing.service.UserService;
import com.ticketing.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String createProject(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project) {
        projectService.save(project);
        project.setProjectStatus(Status.OPEN);
        return "redirect:/project/create";

    }

    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode) {
        projectService.deleteById(projectcode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectcode) {
        projectService.complete(projectService.findById(projectcode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectcode, Model model) {

        model.addAttribute("project", projectService.findById(projectcode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/update";
    }

    @PostMapping("/update/{projectcode}")
    public String updateProject(@PathVariable("projectcode") String projectcode, ProjectDTO project, Model model) {

        projectService.update(project);

        return "redirect:/project/create";
    }

    @GetMapping("/manager/complete")
    public String getProjectsByManager(Model model) {
        UserDTO manager = userService.findById("john@outlook.com");
        List<ProjectDTO> projects = getCountedListOfProjectDTO(manager);
        model.addAttribute("projects", projects);

        return "/manager/project-status";
    }

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projects = projectService
                .findAll()
                .stream()
                .filter(x -> x.getAssignedManager()
                        .equals(manager))
                .map(x -> {
                    List<TaskDTO> taskList = taskService.findTaskByManager(manager);
                    int completeCount = (int) taskList.stream().filter(t -> t.getProject().equals(x) && t.getTaskStatus() == Status.COMPLETE).count();
                    int incompleteCount = (int) taskList.stream().filter(t -> t.getProject().equals(x) && t.getTaskStatus() != Status.COMPLETE).count();

                    x.setCompleteTaskCounts(completeCount);
                    x.setUnfinishedTaskCounts(incompleteCount);
//                    return new ProjectDTO(x.getProjectName(), x.getProjectCode(),
//                            userService.findById(x.getAssignedManager().getUserName()),
//                            x.getStartDate(), x.getEndDate(), x.getProjectDetail(), x.getProjectStatus(), completeCount, incompleteCount);
                    return x;
                }).collect(Collectors.toList());
        return projects;
    }
}