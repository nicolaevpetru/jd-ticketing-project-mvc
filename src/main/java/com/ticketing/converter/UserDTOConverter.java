package com.ticketing.converter;


import com.ticketing.dto.UserDTO;
import com.ticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<String, UserDTO> {


    @Autowired
    UserService userService;

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
