package com.ticketing.service;

import com.ticketing.dto.UserDTO;

import java.util.List;

public interface UserService {

    // **** Business requirements ****

    // Save the user
    // Find the user by username
    // Return a List<User>

    UserDTO save(UserDTO user);

    UserDTO findByID(String username);

    List<UserDTO> findAll();

    void delete(UserDTO user);

    void deleteByID(String username);

}
