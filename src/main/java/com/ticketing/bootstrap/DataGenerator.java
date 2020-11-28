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

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@" + faker.internet().domainName(), "Abc1", true, "7459684532", manager, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@" + faker.internet().domainName(), "Abc2", true, "7459684532", admin, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@" + faker.internet().domainName(), "123", true, "8567412358", manager, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@" + faker.internet().domainName(), "Abc3", true, "7777775566", employee, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@" + faker.internet().domainName(), "Abc4", true, "3256987412", manager, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@" + faker.internet().domainName(), "Abc4", true, "5306987412", employee, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@" + faker.internet().domainName(), "Abc4", true, "9996987412", employee, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "maria@" + faker.internet().domainName(), "Abc4", true, "8881239846", employee, Gender.MALE);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


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
