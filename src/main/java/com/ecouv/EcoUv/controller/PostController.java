package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.CrearPostRequest;
import com.ecouv.EcoUv.dto.PostResponseDTO;
import com.ecouv.EcoUv.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Crear post
    @PostMapping
    public ResponseEntity<PostResponseDTO> crearPost(@RequestBody CrearPostRequest req) {
        return ResponseEntity.ok(postService.crearPost(req));
    }

    // Listar todos
    @GetMapping
    public List<PostResponseDTO> listarTodos() {
        return postService.listarTodos();
    }

    // Eliminar post (solo autor)
    @DeleteMapping("/{postId}/{usuarioId}")
    public ResponseEntity<?> eliminarPost(@PathVariable Long postId,
                                          @PathVariable Long usuarioId) {
        postService.eliminarPost(postId, usuarioId);
        return ResponseEntity.ok().build();
    }

    // Editar post
    @PutMapping("/{postId}/{usuarioId}")
    public ResponseEntity<PostResponseDTO> editarPost(@PathVariable Long postId,
                                                      @PathVariable Long usuarioId,
                                                      @RequestBody CrearPostRequest req) {
        return ResponseEntity.ok(postService.editarPost(postId, usuarioId, req));
    }
}
