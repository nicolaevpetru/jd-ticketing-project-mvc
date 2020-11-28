package com.ticketing.service;

import com.ticketing.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO, String> {


    void complete(ProjectDTO project);

}
