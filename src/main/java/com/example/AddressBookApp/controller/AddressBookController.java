package com.example.AddressBookApp.controller;


import com.example.AddressBookApp.model.AddressBookModel;
import com.example.AddressBookApp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressBookController {

    @Autowired
    private AddressBookRepo repository;

    @PostMapping
    public AddressBookModel createAddress(@RequestBody AddressBookModel address) {
        return repository.save(address);
    }

    @GetMapping
    public List<AddressBookModel> getAllAddresses() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getAddressById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateAddress(@PathVariable Long id, @RequestBody AddressBookModel addressDetails) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}