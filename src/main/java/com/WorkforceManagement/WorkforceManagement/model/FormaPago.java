package com.WorkforceManagement.WorkforceManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "formapagos")
public class FormaPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormaPago;
    
    private String formaPago;
}
