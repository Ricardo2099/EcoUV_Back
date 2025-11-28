package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.LoginRequest;
import com.ecouv.EcoUv.dto.RegistroRequest;
import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.model.Plan;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.repository.CarreraRepository;
import com.ecouv.EcoUv.repository.GrupoRepository;
import com.ecouv.EcoUv.repository.PlanRepository;
import com.ecouv.EcoUv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CarreraRepository carreraRepository;
    private final PlanRepository planRepository;
    private final GrupoRepository grupoRepository;

    /**
     * Registrar un nuevo usuario alumno.
     */
    public User registrarUsuario(RegistroRequest req) {

        if (userRepository.existsByEmailInstitucional(req.getEmailInstitucional())) {
            throw new RuntimeException("El correo institucional ya está registrado");
        }

        if (userRepository.existsByMatricula(req.getMatricula())) {
            throw new RuntimeException("La matrícula ya está registrada");
        }

        Carrera carrera = carreraRepository.findById(req.getCarreraId())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Plan plan = planRepository.findById(req.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        Grupo grupo = grupoRepository.findById(req.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        User user = new User();
        user.setNombres(req.getNombres());
        user.setApellidos(req.getApellidos());
        user.setEmailInstitucional(req.getEmailInstitucional());
        user.setMatricula(req.getMatricula());

        // POR AHORA: password plano para priorizar funcionalidad (luego metemos BCrypt)
        user.setPasswordHash(req.getPassword());

        user.setCarrera(carrera);
        user.setPlan(plan);
        user.setGrupo(grupo);
        user.setSemestre(req.getSemestre());
        user.setCampus(req.getCampus());

        return userRepository.save(user);
    }

    /**
     * Login simple: valida correo + password y devuelve el usuario.
     */
    public User login(LoginRequest req) {
        User user = userRepository.findByEmailInstitucional(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Como estamos guardando password plano en passwordHash, comparamos directo.
        if (!user.getPasswordHash().equals(req.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return user;
    }

    /**
     * Obtener usuario por id (para perfil, etc.)
     */
    public User obtenerPorId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
