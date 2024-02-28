package com.k1per32.test_task.controller;

import com.k1per32.test_task.dto.ClientDto;
import com.k1per32.test_task.dto.ContactClientDto;
import com.k1per32.test_task.dto.EmailAddressDto;
import com.k1per32.test_task.dto.PhoneNumberDto;
import com.k1per32.test_task.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;


@RestController
@RequestMapping("/contact/{id}")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;


    @Operation(
            summary = "Добавление email клиенту",
            tags = {"Contact service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))),
    })
    @PostMapping("/email")
    public ResponseEntity<EmailAddressDto> addEmail(@RequestBody EmailAddressDto emailAddressDto,
                                                    @PathVariable Integer id) {
        return ResponseEntity.ok(contactService.addEmail(emailAddressDto, id));
    }

    @Operation(
            summary = "Добавление телефона клиенту",
            tags = {"Contact service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))),
    })
    @PostMapping("/phone")
    public ResponseEntity<PhoneNumberDto> addEmail(@RequestBody PhoneNumberDto phoneNumberDto,
                                                   @PathVariable Integer id) {
        return ResponseEntity.ok(contactService.addPhone(phoneNumberDto, id));
    }

    @Operation(
            summary = "Получение списка контактов заданного клиента",
            tags = {"Contact service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))),
    })
    @GetMapping()
    public ResponseEntity<ContactClientDto> getContact(@PathVariable int id) {
        return ResponseEntity.ok(contactService.getContact(id));
    }

    @Operation(
            summary = "Получение списка контактов заданного типа заданного клиента",
            tags = {"Contact service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))),
    })
    @GetMapping("/type")
    public ResponseEntity<Object> getContact(@PathVariable int id,  @QueryParam("type") String type) {
        return ResponseEntity.ok(contactService.getContactForCurrentType(id, type));
    }
}
