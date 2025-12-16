package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.NotificacionResponse;
import com.ecouv.EcoUv.service.NotificacionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    // Ej: GET /api/notificaciones?userId=1&page=0&size=20
    @GetMapping
    public Page<NotificacionResponse> listar(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return notificacionService.listar(userId, page, size);
    }

    // Ej: GET /api/notificaciones/unread-count?userId=1
    @GetMapping("/unread-count")
    public long unreadCount(@RequestParam Long userId) {
        return notificacionService.contarNoLeidas(userId);
    }

    // Ej: PATCH /api/notificaciones/5/leer?userId=1
    @PatchMapping("/{id}/leer")
    public void marcarLeida(@PathVariable Long id, @RequestParam Long userId) {
        notificacionService.marcarLeida(id, userId);
    }
}
