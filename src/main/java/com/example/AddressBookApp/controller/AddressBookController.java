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

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    // GET all addresses
    @GetMapping
    public List<AddressBookDTO> getAllAddresses() {
        return service.getAllAddresses();
    }

    // GET Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressById(@PathVariable Long id) {
        return service.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST (Add new Address)
    @PostMapping
    public ResponseEntity<AddressBookDTO> addAddress(@RequestBody AddressBookDTO address) {
        return ResponseEntity.ok(service.addAddress(address));
    }

    // PUT (Update Address by ID)
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddress(@PathVariable Long id, @RequestBody AddressBookDTO newAddress) {
        return service.updateAddress(id, newAddress)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE Address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        return service.deleteAddress(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}