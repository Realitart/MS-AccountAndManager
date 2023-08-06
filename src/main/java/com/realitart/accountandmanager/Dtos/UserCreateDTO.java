package com.realitart.accountandmanager.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {
    @NotNull(message = "El campo 'idUserType' no puede estar vacío o ser nulo.")
    Long idUserType;
    @NotBlank(message = "El campo 'password' no puede estar vacío o ser nulo.")
    private String password;
    @NotBlank(message = "El campo 'username' no puede estar vacío o ser nulo.")
    private String username;
    @NotBlank(message = "El campo 'name' no puede estar vacío o ser nulo.")
    private String name;
    @NotBlank(message = "El campo 'email' no puede estar vacío o ser nulo.")
    private String email;
    private Boolean activeNotifications;
    private Long imageId;
}
