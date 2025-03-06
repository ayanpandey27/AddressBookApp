package com.example.AddressBookApp.controller;


import com.example.AddressBookApp.dto.AddressBookDTO;
import com.example.AddressBookApp.model.AddressBookModel;
import com.example.AddressBookApp.repository.AddressBookRepo;
import com.example.AddressBookApp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @PostMapping
    public AddressBookDTO createAddress(@RequestBody AddressBookDTO address) {
        return addressBookService.createAddress(address);
    }

    @GetMapping
    public List<AddressBookDTO> getAllAddresses() {
        return addressBookService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressById(@PathVariable Long id) {
        return addressBookService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddress(@PathVariable Long id, @RequestBody AddressBookDTO addressDetails) {
        return addressBookService.updateAddress(id,addressDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        return addressBookService.deleteAddress(id);
    }
}