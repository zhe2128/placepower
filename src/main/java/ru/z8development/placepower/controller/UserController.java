package ru.z8development.placepower.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.z8development.placepower.dto.signin.SignInRequestDTO;
import ru.z8development.placepower.dto.signin.SignInResponseDTO;
import ru.z8development.placepower.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public SignInResponseDTO create(@RequestBody @Valid SignInRequestDTO signInRequestDTO) {
        return userService.signIn(signInRequestDTO);
    }
}
