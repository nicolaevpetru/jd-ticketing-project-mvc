package com.ticketing.implementation;

import com.ticketing.dto.TaskDTO;
import com.ticketing.dto.UserDTO;
import com.ticketing.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void update(TaskDTO object) {
        TaskDTO foundProject = findById(object.getId());
        object.setAssignedDate(foundProject.getAssignedDate());
        object.setTaskStatus(foundProject.getTaskStatus());
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }


    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return super.findAll().stream().filter(task -> task.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }
}
