package ru.z8development.placepower.dto.message;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SendMessageDTO {
    @NotNull
    private Long userId;

    @NotBlank
    private String text;
}
