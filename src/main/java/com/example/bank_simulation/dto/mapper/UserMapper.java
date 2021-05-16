package com.example.bank_simulation.dto.mapper;

import com.example.bank_simulation.dto.UserDTO;
import com.example.bank_simulation.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toUser(UserDTO userDTO);


    UserDTO toUserDTO(User user);
}
