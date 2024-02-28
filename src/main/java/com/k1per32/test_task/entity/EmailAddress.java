package com.k1per32.test_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "email_address", schema = "test_task_schema")
public class EmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_address_id", nullable = false)
    private int emailAddressId;
    @Column(name = "email_address")
    private String emailAddress;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}