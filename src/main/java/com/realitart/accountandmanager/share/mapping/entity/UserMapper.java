package com.realitart.accountandmanager.share.mapping.entity;

import com.realitart.accountandmanager.Domain.User;
import com.realitart.accountandmanager.Dtos.UserCreateDTO;
import com.realitart.accountandmanager.Dtos.UserDTO;
import com.realitart.accountandmanager.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class UserMapper {
    @Autowired
    EnhancedModelMapper mapper;


    public UserDTO toResource(User model) {
        return mapper.map(model, UserDTO.class);
    }

    public Page<UserDTO> modelListToPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserDTO.class), pageable, modelList.size());
    }
    public User toModel(UserCreateDTO resource) {
        return mapper.map(resource, User.class);
    }

}
