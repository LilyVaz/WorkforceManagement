package com.WorkforceManagement.WorkforceManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Entidades")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntidad;
    
    private String entidad;

    @ManyToOne
    @JoinColumn(name = "idRubro", nullable = false)
    private Rubro rubro;
}
