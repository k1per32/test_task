package com.k1per32.test_task.mapper;

import com.k1per32.test_task.dto.EmailAddressDto;
import com.k1per32.test_task.entity.EmailAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailAddressMapper {
    EmailAddress convertToEmailAddress(EmailAddressDto emailAddressDto);

    EmailAddressDto convertToEmailAddressDto(EmailAddress emailAddress);
}
