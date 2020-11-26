package com.ticketing.bootstrap;

import com.github.javafaker.Faker;
import com.ticketing.dto.RoleDTO;
import com.ticketing.dto.UserDTO;
import com.ticketing.service.RoleService;
import com.ticketing.service.UserService;
import com.ticketing.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService; // Dependency Injection
    UserService userService; // Dependency Injection

    @Autowired
    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

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
    }
}
