package com.ticketing.service;

import com.ticketing.dto.TaskDTO;
import com.ticketing.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTaskByManager(UserDTO manager);
}
