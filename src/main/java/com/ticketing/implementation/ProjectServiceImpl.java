package com.ticketing.implementation;

import com.ticketing.dto.ProjectDTO;
import com.ticketing.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public void update(ProjectDTO object) {

        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);

    }

    @Override
    public void delete(ProjectDTO object) {
        super.delete(object);

    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }
}
