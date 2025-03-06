package com.example.AddressBookApp.service;

import com.example.AddressBookApp.dto.AddressBookDTO;
import com.example.AddressBookApp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    private final List<AddressBookDTO> addressList = new ArrayList<>();
    private Long idCounter = 1L;

    // Get all addresses
    public List<AddressBookDTO> getAllAddresses() {
        return addressList;
    }

    // Get Address by ID
    public Optional<AddressBookDTO> getAddressById(Long id) {
        return addressList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();
    }

    // Add a new Address
    public AddressBookDTO addAddress(AddressBookDTO address) {
        address.setId(idCounter++); // Assign ID manually
        addressList.add(address);
        return address;
    }

    // Update Address by ID
    public Optional<AddressBookDTO> updateAddress(Long id, AddressBookDTO newAddress) {
        return getAddressById(id).map(existing -> {
            existing.setName(newAddress.getName());
            existing.setPhone(newAddress.getPhone());
            existing.setEmail(newAddress.getEmail());
            return existing;
        });
    }

    // Delete Address by ID
    public boolean deleteAddress(Long id) {
        return addressList.removeIf(entry -> entry.getId().equals(id));
    }
}