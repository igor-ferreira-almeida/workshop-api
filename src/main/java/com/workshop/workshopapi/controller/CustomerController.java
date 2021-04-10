package com.workshop.workshopapi.controller;

import com.workshop.workshopapi.model.entity.Customer;
import com.workshop.workshopapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody @Valid Customer customer) {
        return repository.save(customer);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer find(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
         repository.findById(id).map(customer -> {
            repository.delete(customer);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@PathVariable Long id, @RequestBody @Valid Customer updateCustomer) {
        return repository.findById(id).map(customer -> {
            customer.setName(updateCustomer.getName());
            customer.setCpf(updateCustomer.getCpf());
            return repository.save(customer);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
