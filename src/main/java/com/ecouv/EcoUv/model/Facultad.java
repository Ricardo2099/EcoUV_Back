package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facultades")
@Data
public class Facultad extends EntidadAcademica {

    @OneToMany(mappedBy = "facultad")
    private List<Carrera> carreras = new ArrayList<>();
}
