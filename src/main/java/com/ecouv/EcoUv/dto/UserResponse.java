package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.User;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String nombres;
    private String apellidos;
    private String nombreCompleto;
    private String emailInstitucional;
    private String matricula;
    private String carrera;
    private String plan;
    private String grupo;
    private Integer semestre;
    private String campus;

    public static UserResponse fromEntity(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setNombres(user.getNombres());
        dto.setApellidos(user.getApellidos());
        dto.setNombreCompleto(user.getNombreCompleto());
        dto.setEmailInstitucional(user.getEmailInstitucional());
        dto.setMatricula(user.getMatricula());
        dto.setCarrera(user.getCarrera() != null ? user.getCarrera().getNombre() : null);
        dto.setPlan(user.getPlan() != null ? user.getPlan().getNombre() : null);
        dto.setGrupo(user.getGrupo() != null ? user.getGrupo().getGrupo() : null);
        dto.setSemestre(user.getSemestre());
        dto.setCampus(user.getCampus());
        return dto;
    }
}
