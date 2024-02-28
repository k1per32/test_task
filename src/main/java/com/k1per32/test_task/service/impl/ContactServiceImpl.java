package com.k1per32.test_task.service.impl;

import com.k1per32.test_task.dto.*;
import com.k1per32.test_task.entity.Client;
import com.k1per32.test_task.entity.EmailAddress;
import com.k1per32.test_task.entity.PhoneNumber;
import com.k1per32.test_task.mapper.EmailAddressMapper;
import com.k1per32.test_task.mapper.PhoneNumberMapper;
import com.k1per32.test_task.repository.ClientRepository;
import com.k1per32.test_task.repository.EmailAddressRepository;
import com.k1per32.test_task.repository.PhoneNumberRepository;
import com.k1per32.test_task.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ContactServiceImpl implements ContactService {

    private final EmailAddressRepository emailAddressRepository;
    private final ClientRepository clientRepository;
    private final EmailAddressMapper emailAddressMapper;
    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberMapper phoneNumberMapper;

    @Override
    public EmailAddressDto addEmail(EmailAddressDto emailAddressDto, Integer id) {
        log.info("Добавление email клиенту");
        if (clientRepository.findById(id).isPresent()) {
            EmailAddress address = new EmailAddress();
            address.setClient(clientRepository.findById(id).get());
            address.setEmailAddress(emailAddressDto.getEmailAddress());
            emailAddressRepository.save(address);
            log.info("Добавление email клиенту завершено");
            return emailAddressMapper.convertToEmailAddressDto(address);
        } else throw new RuntimeException("Клиента с id: " + id + " не существует");
    }

    @Override
    public PhoneNumberDto addPhone(PhoneNumberDto phoneNumberDto, Integer id) {
        log.info("Добавление phone клиенту");
        if (clientRepository.findById(id).isPresent()) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setClient(clientRepository.findById(id).get());
            phoneNumber.setPhoneNumber(phoneNumberDto.getPhoneNumber());
            phoneNumberRepository.save(phoneNumber);
            log.info("Добавление phone клиенту завершено");
            return phoneNumberMapper.convertToPhoneNumberDto(phoneNumber);
        } else throw new RuntimeException("Клиента с id: " + id + " не существует");
    }

    @Override
    public ContactClientDto getContact(Integer id) {
        log.info("Получение списка контактов заданного клиента");
        if (clientRepository.findById(id).isPresent()) {
            ContactClientDto clientDto = new ContactClientDto();
            Client client = clientRepository.getReferenceById(id);
            clientDto.setEmail(client.getEmailAddresses().stream().map(emailAddressMapper::convertToEmailAddressDto).collect(Collectors.toList()));
            clientDto.setPhoneNumber(client.getPhoneNumbers().stream().map(phoneNumberMapper::convertToPhoneNumberDto).collect(Collectors.toList()));
            clientDto.setName(client.getName());
            log.info("Получение списка контактов заданного клиента завершено");
            return clientDto;
        } else throw new RuntimeException("Клиента с id: " + id + " не существует");
    }

    @Override
    public Object getContactForCurrentType(Integer id, String type) {

        log.info("Получение списка контактов заданного типа заданного клиента");
        if (clientRepository.findById(id).isPresent()) {
            Client client = clientRepository.getReferenceById(id);
            if (type.equalsIgnoreCase("email")) {
                ClientNameAndEmailDto clientNameAndEmailDto = new ClientNameAndEmailDto();
                clientNameAndEmailDto.setEmail(client.getEmailAddresses()
                        .stream()
                        .map(emailAddressMapper::convertToEmailAddressDto)
                        .collect(Collectors.toList()));
                clientNameAndEmailDto.setName(client.getName());
                log.info("Получение списка контактов заданного типа заданного клиента завершено");
                return clientNameAndEmailDto;
            }
            if (type.equalsIgnoreCase("phone number")) {
                ClientNameAndPhoneNumberDto clientNameAndPhoneNumberDto = new ClientNameAndPhoneNumberDto();
                clientNameAndPhoneNumberDto.setPhoneNumber(client.getPhoneNumbers()
                        .stream()
                        .map(phoneNumberMapper::convertToPhoneNumberDto)
                        .collect(Collectors.toList()));
                clientNameAndPhoneNumberDto.setName(client.getName());
                log.info("Получение списка контактов заданного типа заданного клиента завершено");
                return clientNameAndPhoneNumberDto;
            } else throw new RuntimeException(type + " заданный тип не существует");
        } else throw new RuntimeException("Клиента с id: " + id + " не существует");
    }


}
