package com.demoRest.api.dto;

import com.demoRest.api.Enum.ERole;
import com.demoRest.api.entities.Role;
import com.demoRest.api.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDto {
    private String username;
    private String email;
    private Set<ERole> role;
    private String password;
    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        // Convertir Set<Role> en Set<ERole>
        if (user.getRoles() != null) {
            this.role = user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());
        }
    }
}