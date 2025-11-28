package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.LoginRequest;
import com.ecouv.EcoUv.dto.RegistroRequest;
import com.ecouv.EcoUv.dto.UserResponse;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Registrar nuevo usuario.
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registrar(@Valid @RequestBody RegistroRequest req) {
        User user = userService.registrarUsuario(req);
        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }

    /**
     * Login simple (sin JWT).
     * Devuelve los datos del usuario si el login es correcto.
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest req) {
        User user = userService.login(req);
        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }

    /**
     * Obtener datos de un usuario por id (para perfil).
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> obtenerPorId(@PathVariable Long id) {
        User user = userService.obtenerPorId(id);
        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }
}
