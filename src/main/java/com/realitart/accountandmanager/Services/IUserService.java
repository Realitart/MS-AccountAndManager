package com.realitart.accountandmanager.Services;

import com.realitart.accountandmanager.Domain.User;
import com.realitart.accountandmanager.Dtos.UserCreateDTO;
import com.realitart.accountandmanager.Dtos.UserDTO;
import com.realitart.accountandmanager.share.response.OperationResponse;

import java.util.List;

public interface IUserService {
    OperationResponse createUser(User request);
    OperationResponse updateUser(Long userId, User request);
    OperationResponse deleteUser(Long userId);
    User getUserData(Long userId);
    List<User> getAllUsers();

}
