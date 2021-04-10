package com.workshop.workshopapi.repository;

import com.workshop.workshopapi.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
