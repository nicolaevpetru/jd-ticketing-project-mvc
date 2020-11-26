package com.ticketing.bootstrap;

import com.github.javafaker.Faker;
import com.ticketing.dto.ProjectDTO;
import com.ticketing.dto.RoleDTO;
import com.ticketing.dto.UserDTO;
import com.ticketing.service.ProjectService;
import com.ticketing.service.RoleService;
import com.ticketing.service.UserService;
import com.ticketing.utils.Gender;
import com.ticketing.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService; // Dependency Injection
    UserService userService; // Dependency Injection
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }
    //    @Autowired
//    RoleService roleService; // Dependency Injection
//    @Autowired
//    UserService userService; // Dependency Injection
//    @Autowired
//    ProjectService projectService;

//    @Autowired
//    public DataGenerator(RoleService roleService, UserService userService) {
//        this.roleService = roleService;
//        this.userService = userService;
//    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        RoleDTO admin = new RoleDTO(1L, "Admin");
        RoleDTO manager = new RoleDTO(2L, "Manager");
        RoleDTO employee = new RoleDTO(3L, "Employee");

        roleService.save(admin);
        roleService.save(manager);
        roleService.save(employee);

        UserDTO user1 = new UserDTO(faker.name().firstName(), faker.name().lastName(),
                faker.internet().emailAddress(), "abc", true, faker.number().digits(10), admin, Gender.MALE);
        UserDTO user5 = new UserDTO(faker.name().firstName(), faker.name().lastName(),
                faker.internet().emailAddress(), "abc", true, faker.number().digits(10), admin, Gender.MALE);
        UserDTO user2 = new UserDTO(faker.name().firstName(),
                faker.name().lastName(), faker.internet().emailAddress(), "123", true, faker.number().digits(10), manager, Gender.MALE);
        UserDTO user3 = new UserDTO(faker.name().firstName(), faker.name().lastName(),
                faker.internet().emailAddress(), "123", true, faker.number().digits(10), employee, Gender.MALE);
        UserDTO user4 = new UserDTO(faker.name().firstName(),
                faker.name().lastName(), faker.internet().emailAddress(), "123", true, faker.number().digits(10), employee, Gender.MALE);


        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);


//        RoleServiceImpl roleService = new RoleServiceImpl();
//        roleService.save(admin);         ====> NEEDS TO BE INJECTION


        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Controls", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(15), "Creating DB", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(45), "Creating container", Status.UAT_TEST);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

    }
}
