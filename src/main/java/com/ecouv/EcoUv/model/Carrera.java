package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carreras")
@Data
public class Carrera extends EntidadAcademica {

    @ManyToOne(optional = false)
    @JoinColumn(name = "facultad_id")
    @JsonIgnore
    private Facultad facultad;

    @OneToMany(mappedBy = "carrera")
    private List<Plan> planes = new ArrayList<>();

    @OneToMany(mappedBy = "carrera")
    private List<Grupo> grupos = new ArrayList<>();
}
