package com.k1per32.test_task.dto;

import com.k1per32.test_task.entity.EmailAddress;
import com.k1per32.test_task.entity.PhoneNumber;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ContactClientDto {
    private String name;

    private List<EmailAddressDto> email;
    private List<PhoneNumberDto> phoneNumber;



}
