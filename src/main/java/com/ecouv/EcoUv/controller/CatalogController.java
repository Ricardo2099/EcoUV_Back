package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Facultad;
import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.model.Plan;
import com.ecouv.EcoUv.repository.CarreraRepository;
import com.ecouv.EcoUv.repository.FacultadRepository;
import com.ecouv.EcoUv.repository.GrupoRepository;
import com.ecouv.EcoUv.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogos")
@RequiredArgsConstructor
public class CatalogController {

    private final FacultadRepository facultadRepository;
    private final CarreraRepository carreraRepository;
    private final PlanRepository planRepository;
    private final GrupoRepository grupoRepository;

    /**
     * Facultades
     */
    @GetMapping("/facultades")
    public List<Facultad> listarFacultades() {
        return facultadRepository.findAll();
    }

    /**
     * Carreras:
     * - Si se manda facultadId -> solo las de esa facultad.
     * - Si no -> todas.
     */
    @GetMapping("/carreras")
    public List<Carrera> listarCarreras(@RequestParam(required = false) Long facultadId) {
        if (facultadId == null) {
            return carreraRepository.findAll();
        }
        Facultad facultad = facultadRepository.findById(facultadId)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));
        return carreraRepository.findByFacultad(facultad);
    }

    /**
     * Planes de estudio de una carrera.
     */
    @GetMapping("/planes")
    public List<Plan> listarPlanes(@RequestParam Long carreraId) {
        Carrera carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        return planRepository.findByCarrera(carrera);
    }

    /**
     * Grupos:
     * - Requiere carreraId.
     * - Opcional semestre = filtra grupos activos por semestre.
     */
    @GetMapping("/grupos")
    public List<Grupo> listarGrupos(
            @RequestParam Long carreraId,
            @RequestParam(required = false) Integer semestre
    ) {
        Carrera carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        if (semestre == null) {
            return grupoRepository.findByCarreraAndActivoTrue(carrera);
        } else {
            return grupoRepository.findByCarreraAndSemestreAndActivoTrue(carrera, semestre);
        }
    }
}
