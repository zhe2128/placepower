package ru.z8development.placepower.service;

import ru.z8development.placepower.dto.signin.SignInRequestDTO;
import ru.z8development.placepower.dto.signin.SignInResponseDTO;

public interface UserService {
    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);
}
