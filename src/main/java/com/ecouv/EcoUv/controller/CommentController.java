package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.CommentResponse;
import com.ecouv.EcoUv.dto.CreateCommentRequest;
import com.ecouv.EcoUv.service.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CommentController {

    private final ComentarioService comentarioService;

    // Crear comentario
    @PostMapping
    public ResponseEntity<CommentResponse> crear(@RequestBody CreateCommentRequest req) {
        return ResponseEntity.ok(comentarioService.crearComentario(req));
    }

    // Listar comentarios de un post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> listarPorPost(@PathVariable Long postId) {
        return ResponseEntity.ok(comentarioService.listarPorPost(postId));
    }
}
