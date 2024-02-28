package com.k1per32.test_task.service.impl;

import com.k1per32.test_task.dto.ClientDto;
import com.k1per32.test_task.entity.Client;
import com.k1per32.test_task.mapper.ClientMapper;
import com.k1per32.test_task.repository.ClientRepository;
import com.k1per32.test_task.service.ClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }


    @Override
    public ClientDto add(ClientDto clientDto) {

        log.info("Добавление клиента");
        Client client = new Client();
        client.setName(clientDto.getName());
        clientRepository.save(client);
        log.info("Добавление клиента завершено");
        return clientMapper.convertToClientDto(client);


    }

    @Override
    public List<ClientDto> getAllClients() {
        log.info("Получаем данные всех пользователей");
        List<Client> userListEntity = clientRepository.findAll();
        log.info("Получение данные всех пользователей завершено");
        return userListEntity.stream()
                .map(clientMapper::convertToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getAllClientsById(Integer id) {
        log.info("Поиск клиента по id");
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиента с данным id: " + id + " не существует"));
        log.info("Поиск клиента по id завершено");
        return clientMapper.convertToClientDto(client);
    }
}
