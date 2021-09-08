package ru.z8development.placepower.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.z8development.placepower.dto.signin.SignInRequestDTO;
import ru.z8development.placepower.dto.signin.SignInResponseDTO;
import ru.z8development.placepower.entity.UserEntity;
import ru.z8development.placepower.repository.UserRepository;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        AtomicReference<SignInResponseDTO> signInResponse = new AtomicReference<>();
        userRepository.findByUsername(signInRequestDTO.getUsername())
                .ifPresentOrElse(userEntity ->
                                signInResponse.set(new SignInResponseDTO(userEntity.getId())),
                        () -> {
                            UserEntity newUser = new UserEntity(signInRequestDTO.getUsername());
                            signInResponse.set(new SignInResponseDTO(userRepository.save(newUser).getId()));
                        });
        return signInResponse.get();
    }
}
