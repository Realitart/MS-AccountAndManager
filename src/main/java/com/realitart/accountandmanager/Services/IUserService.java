package com.realitart.accountandmanager.Services;

import com.realitart.accountandmanager.Domain.User;
import com.realitart.accountandmanager.Dtos.UserCreateDTO;
import com.realitart.accountandmanager.Dtos.UserDTO;
import com.realitart.accountandmanager.share.response.OperationResponse;

import java.util.List;

public interface IUserService {
    UserDTO createUser(User request);
    UserDTO updateUser(Long userId, User request);
    OperationResponse deleteUser(Long userId);
    User getUserData(Long userId);
    User getUserDataByUsername(String username);
    List<User> getAllUsers();

}
