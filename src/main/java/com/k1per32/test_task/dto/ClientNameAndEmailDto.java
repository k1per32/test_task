package com.k1per32.test_task.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientNameAndEmailDto {
    private String name;
    private List<EmailAddressDto> email;

}
