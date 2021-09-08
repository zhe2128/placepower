package ru.z8development.placepower.service;

import ru.z8development.placepower.dto.message.MessageDTO;
import ru.z8development.placepower.dto.message.SendMessageDTO;

import java.time.ZoneId;
import java.util.List;

public interface MessageService {
    void send(SendMessageDTO sendMessageDTO);

    List<MessageDTO> getMessages(ZoneId zoneId);
}
