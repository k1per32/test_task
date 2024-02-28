package com.k1per32.test_task.controller;


import com.k1per32.test_task.dto.ClientDto;
import com.k1per32.test_task.entity.Client;
import com.k1per32.test_task.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @Operation(
            summary = "Добавление клиентов",
            tags = {"Client service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))),
    })
    @PostMapping("/add")
    public ResponseEntity<ClientDto> add(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.add(clientDto));
    }


    @Operation(
            summary = "Получение списка всех клиентов",
            tags = {"Client service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = List.class)))),
    })
    @GetMapping
    public ResponseEntity<List<ClientDto>> listUsers() {
        return ResponseEntity.ok(clientService.getAllClients());
    }


    @Operation(
            summary = "Получение данных пользователя по его id",
            tags = {"Client service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Client.class)))),
           })
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.getAllClientsById(id));
    }
//
//    @Operation(
//            summary = "Удаление пользователя",
//            tags = {"User service"})
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = List.class)))),
//            @ApiResponse(responseCode = "404", description = "No value present", content = @Content(array = @ArraySchema(schema = @Schema(implementation = NoSuchElementException.class)))),
//    })
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//    }
//
//}
}
