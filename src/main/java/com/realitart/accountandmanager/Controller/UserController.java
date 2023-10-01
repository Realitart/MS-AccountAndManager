package com.realitart.accountandmanager.Controller;

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

    @GetMapping("/{userId}")
    @Operation(summary = "Get a user by id")
    ResponseEntity<UserDTO> getUserData(@PathVariable Long userId){
        return ResponseEntity.ok(mapper.toResource(userService.getUserData(userId)));
    }
    @GetMapping("/{username}")
    @Operation(summary = "Get a user by username")
    ResponseEntity<UserDTO> getUserData(@PathVariable String userId){
        return ResponseEntity.ok(mapper.toResource(userService.getUserDataByUsername(userId)));
    }

    @GetMapping()
    @Operation(summary = "Get all users")
    ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable){
        return ResponseEntity.ok(mapper.modelListToPage(userService.getAllUsers(),pageable));
    }
}
