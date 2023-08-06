package com.realitart.accountandmanager.Dtos;

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
public class UserDTO {
    Long id;
    Long idUserType;
    private String username;
    private String name;
    private String email;
    private Boolean activeNotifications;
    private Long imageId;

}
