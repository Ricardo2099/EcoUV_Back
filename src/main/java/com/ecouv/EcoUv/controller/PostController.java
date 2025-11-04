package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Más adelante protegemos con seguridad/JWT.
// Por ahora lo dejamos público para poder probar.
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Crear post
    // Ejemplo de uso (temporal sin auth real):
    // POST /api/posts?userId=1&grupoId=2&contenido=Hola%20a%20todos
    @PostMapping
    public Post crearPost(
            @RequestParam Long userId,
            @RequestParam Long grupoId,
            @RequestParam String contenido,
            @RequestParam(required = false) String adjuntoUrl
    ) {
        return postService.crearPost(userId, grupoId, contenido, adjuntoUrl);
    }

    // Obtener feed de un grupo concreto
    // GET /api/posts/grupo/2
    @GetMapping("/grupo/{grupoId}")
    public List<Post> feedPorGrupo(@PathVariable Long grupoId) {
        return postService.feedDeGrupo(grupoId);
    }
}
