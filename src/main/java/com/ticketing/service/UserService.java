package com.ticketing.service;
import com.ticketing.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String>{

    // **** Business requirements ****

    // Save the user
    // Find the user by username
    // Return a List<User>

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();
}
