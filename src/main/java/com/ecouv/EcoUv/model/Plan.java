package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planes")
@Data
public class Plan extends EntidadAcademica {

    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    @JsonIgnore
    private Carrera carrera;

    @OneToMany(mappedBy = "plan")
    private List<Grupo> grupos = new ArrayList<>();
}
