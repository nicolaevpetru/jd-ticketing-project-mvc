package com.ticketing.implementation;

import com.ticketing.dto.UserDTO;
import com.ticketing.service.UserService;

import java.util.List;

public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);

    }

    @Override
    public void delete(UserDTO object) {
        super.delete(object);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }
}
