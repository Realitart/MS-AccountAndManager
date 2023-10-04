package com.realitart.accountandmanager.Controller;

import com.realitart.accountandmanager.Domain.User;
import com.realitart.accountandmanager.Dtos.UserCreateDTO;
import com.realitart.accountandmanager.Dtos.UserDTO;
import com.realitart.accountandmanager.Services.IUserService;
import com.realitart.accountandmanager.share.mapping.entity.UserMapper;
import com.realitart.accountandmanager.share.response.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    private UserMapper mapper;

    @PostMapping()
    @Operation(summary = "Create a new user")
    UserDTO createUser(@Valid @RequestBody UserCreateDTO request){
        return userService.createUser(mapper.toModel(request));
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete a user")
    OperationResponse deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update a user")
    UserDTO updateUser(@PathVariable Long userId,@RequestBody UserCreateDTO request){
        return userService.updateUser(userId,mapper.toModel(request));
    }

//    @GetMapping()
//    @Operation(summary = "Get a user by id")
//    ResponseEntity<UserDTO> getUserData(@PathVariable(required = false) Long userId,@PathVariable(required = false) String username){
//        if(userId == null && username != null) return ResponseEntity.ok(mapper.toResource(userService.getUserDataByUsername(username)));
//        if (username != null) {
//            return ResponseEntity.ok(mapper.toResource(userService.getUserDataByUsername(username)));
//        } else {
//            return ResponseEntity.ok(mapper.toResource(userService.getUserData(userId)));
//        }
//    }
@GetMapping("/{userIdOrUsername}")
@Operation(summary = "Get a user by ID or username")
public ResponseEntity<UserDTO> getUserData(@PathVariable String userIdOrUsername) {
    User userDTO = null;

    try {
        Long userId = Long.parseLong(userIdOrUsername);
        userDTO = userService.getUserData(userId);
    } catch (NumberFormatException e) {
        // El parámetro no es un ID válido, asumimos que es un nombre de usuario
        userDTO = userService.getUserDataByUsername(userIdOrUsername);
    }

    if (userDTO != null) {
        return ResponseEntity.ok(mapper.toResource(userDTO));
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @GetMapping()
    @Operation(summary = "Get all users")
    ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable){
        return ResponseEntity.ok(mapper.modelListToPage(userService.getAllUsers(),pageable));
    }
}
