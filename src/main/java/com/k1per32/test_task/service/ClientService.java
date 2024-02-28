package com.k1per32.test_task.service;

import com.k1per32.test_task.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto add(ClientDto clientDto);

    List<ClientDto> getAllClients();

    ClientDto getAllClientsById(Integer id);
}
