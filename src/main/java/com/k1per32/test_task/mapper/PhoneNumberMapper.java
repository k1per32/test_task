package com.k1per32.test_task.mapper;

import com.k1per32.test_task.dto.PhoneNumberDto;
import com.k1per32.test_task.entity.PhoneNumber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneNumberMapper {
    PhoneNumber convertToPhoneNumber(PhoneNumberDto phoneNumberDto);

    PhoneNumberDto convertToPhoneNumberDto(PhoneNumber phoneNumber);
}
