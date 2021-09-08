package ru.z8development.placepower.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class MessageDTO {
    private String author;
    private String text;
    private OffsetDateTime datetime;
}
