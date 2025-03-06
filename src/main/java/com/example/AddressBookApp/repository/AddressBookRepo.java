package com.example.AddressBookApp.repository;

import com.example.AddressBookApp.model.AddressBookModel;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookModel, Long> {
}