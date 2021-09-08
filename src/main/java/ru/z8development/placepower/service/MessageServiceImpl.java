package ru.z8development.placepower.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.z8development.placepower.dto.message.MessageDTO;
import ru.z8development.placepower.dto.message.SendMessageDTO;
import ru.z8development.placepower.entity.MessageEntity;
import ru.z8development.placepower.entity.UserEntity;
import ru.z8development.placepower.exception.UserNotFoundException;
import ru.z8development.placepower.repository.MessageRepository;
import ru.z8development.placepower.repository.UserRepository;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public void send(SendMessageDTO sendMessageDTO) {
        UserEntity user = userRepository.findById(sendMessageDTO.getUserId()).orElseThrow(UserNotFoundException::new);
        messageRepository.save(new MessageEntity(sendMessageDTO.getText(), Instant.now(), user));
    }

    @Override
    public List<MessageDTO> getMessages(ZoneId zoneId) {
        return messageRepository.findAll()
                .stream()
                .map(messageEntity -> new MessageDTO(
                        messageEntity.getAuthor().getUsername(),
                        messageEntity.getText(),
                        OffsetDateTime.ofInstant(messageEntity.getDateTime(), zoneId)))
                .collect(Collectors.toList());
    }
}
