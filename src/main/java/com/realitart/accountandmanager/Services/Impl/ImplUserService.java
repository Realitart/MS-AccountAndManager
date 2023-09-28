package com.realitart.accountandmanager.Services.Impl;

import com.realitart.accountandmanager.Domain.Repositories.IUserRepostory;
import com.realitart.accountandmanager.Domain.User;
import com.realitart.accountandmanager.Dtos.UserDTO;
import com.realitart.accountandmanager.Services.IUserService;
import com.realitart.accountandmanager.share.exceptions.ResourceNotFoundException;
import com.realitart.accountandmanager.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ImplUserService implements IUserService {
    private static final String ENTITY = "User";

    @Autowired
    IUserRepostory _userRepo;


    @Override
    public UserDTO createUser(User request) {
        try{
            request.setId(null);
            User user = _userRepo.save(request);
            return new UserDTO(user.getId(), user.getIdUserType().getId(), user.getUsername(), user.getName(), user.getEmail(), user.getActiveNotifications(), user.getImageId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al crear el usuario", e);
        }

    }

    @Override
    public UserDTO updateUser(Long userId, User request) {
        return _userRepo.findById(userId).map(
                user -> {
                    if(request.getName() != null) user.setName(request.getName());
                    if(request.getEmail() != null) user.setEmail(request.getEmail());
//                    if(request.getPassword() != null) user.setPassword(request.getPassword());
                    if(request.getActiveNotifications() != null) user.setActiveNotifications(request.getActiveNotifications());
                    if(request.getImageId() != null) user.setImageId(request.getImageId());
                    if(request.getUsername() != null) user.setUsername(request.getUsername());

                   User userResp = _userRepo.save(user);

                    return new UserDTO(userResp.getId(), userResp.getIdUserType().getId(), userResp.getUsername(), userResp.getName(), userResp.getEmail(), userResp.getActiveNotifications(), userResp.getImageId());
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));

    }

    @Override
    public OperationResponse deleteUser(Long userId) {
        try{
            _userRepo.deleteById(userId);
            return new OperationResponse(true, "Usuario eliminado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al eliminar el usuario", e);
        }
    }

    @Override
    public User getUserData(Long userId) {
        try{
            return _userRepo.findById(userId).get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el usuario", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try{
            return _userRepo.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los usuarios", e);
        }
    }


}
