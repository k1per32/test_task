package com.k1per32.test_task.service;

import com.k1per32.test_task.dto.ContactClientDto;
import com.k1per32.test_task.dto.EmailAddressDto;
import com.k1per32.test_task.dto.PhoneNumberDto;

public interface ContactService {
    EmailAddressDto addEmail(EmailAddressDto emailAddressDto, Integer id);

    PhoneNumberDto addPhone(PhoneNumberDto phoneNumberDto, Integer id);

    ContactClientDto getContact(Integer id);


    Object getContactForCurrentType(Integer id, String type);
}
