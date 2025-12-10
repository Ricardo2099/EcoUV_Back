package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "grupos")
@Data
public class Grupo extends EntidadAcademica {

    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    @JsonIgnore
    private Carrera carrera;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plan_id")
    @JsonIgnore
    private Plan plan;
}
