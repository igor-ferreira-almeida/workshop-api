package com.workshop.workshopapi.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    @NotEmpty(message = "{customer.attribute.name.empty}")
    private String name;

    @Column(length = 11, nullable = false)
    @NotEmpty(message = "{customer.attribute.cpf.empty}")
    @CPF(message = "{customer.attribute.cpf.invalid}")
    private String cpf;

    @Column(name = "created_date", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }
}