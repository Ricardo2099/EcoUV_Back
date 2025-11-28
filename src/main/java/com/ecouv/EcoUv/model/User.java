package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. Datos personales
    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    // 2. Credenciales
    @Column(nullable = false, unique = true, length = 150)
    private String emailInstitucional;

    @Column(nullable = false, unique = true, length = 20)
    private String matricula;

    @Column(nullable = false)
    private String passwordHash;

    // 3. Datos académicos
    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Column(nullable = false)
    private Integer semestre;

    @Column(nullable = false, length = 50)
    private String campus;

    // Helper POO
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    /* ====== UserDetails (para más adelante cuando metas seguridad) ====== */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Por ahora todos son ROLE_USER
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return emailInstitucional;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
