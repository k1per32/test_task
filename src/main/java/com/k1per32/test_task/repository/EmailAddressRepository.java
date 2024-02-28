package com.k1per32.test_task.repository;

import com.k1per32.test_task.entity.Client;
import com.k1per32.test_task.entity.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAddressRepository extends JpaRepository<EmailAddress, Integer> {

    String findByClient(Client client);
}
