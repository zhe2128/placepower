package ru.z8development.placepower.dto.signin;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SignInRequestDTO {
    @NotBlank
    @Pattern(regexp = "^[0-9A-Za-z_]{1,20}$")
    private String username;
}
