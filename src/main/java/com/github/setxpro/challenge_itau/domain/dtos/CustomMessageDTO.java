package com.github.setxpro.challenge_itau.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomMessageDTO {
    private String message;
    private int code;
}
