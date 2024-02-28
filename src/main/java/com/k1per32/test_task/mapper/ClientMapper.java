package com.k1per32.test_task.mapper;

import com.k1per32.test_task.dto.ClientDto;
import com.k1per32.test_task.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client convertToClient(ClientDto clientDto);

    ClientDto convertToClientDto(Client client);
}
