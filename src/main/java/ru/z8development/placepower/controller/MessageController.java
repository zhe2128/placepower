package ru.z8development.placepower.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.z8development.placepower.dto.message.MessageDTO;
import ru.z8development.placepower.dto.message.SendMessageDTO;
import ru.z8development.placepower.service.MessageService;

import javax.validation.Valid;
import java.time.ZoneId;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createMessage(@RequestBody @Valid SendMessageDTO sendMessageDTO) {
        messageService.send(sendMessageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(@RequestHeader(value = "Time-Zone", required = false) String timeZone) {
        return ResponseEntity.ok(messageService.getMessages(isNull(timeZone) ? ZoneId.systemDefault() : ZoneId.of(timeZone)));
    }
}
