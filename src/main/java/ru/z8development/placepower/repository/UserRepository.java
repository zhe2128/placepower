package ru.z8development.placepower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z8development.placepower.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
