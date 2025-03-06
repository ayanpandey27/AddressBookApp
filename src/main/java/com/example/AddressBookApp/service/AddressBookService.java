package com.example.AddressBookApp.service;

import com.example.AddressBookApp.dto.AddressBookDTO;
import com.example.AddressBookApp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepo repository;

    public AddressBookDTO createAddress(AddressBookDTO address)
    {
        return repository.save(address);
    }
    public List<AddressBookDTO> getAllAddresses()
    {
        return repository.findAll();
    }
    public ResponseEntity<AddressBookDTO> getAddressById(Long id)
    {
        return
                repository.findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<AddressBookDTO> updateAddress(Long id ,AddressBookDTO addressDetails)
    {
        return repository.findById(id)
                .map(address -> {
                    address.setName(addressDetails.getName());
                    address.setPhone(addressDetails.getPhone());
                    address.setEmail(addressDetails.getEmail());
                    address.setAddress(addressDetails.getAddress());
                    return ResponseEntity.ok(repository.save(address));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Void> deleteAddress(Long id)
    {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}