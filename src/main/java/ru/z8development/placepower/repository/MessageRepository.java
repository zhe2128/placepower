package ru.z8development.placepower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z8development.placepower.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
