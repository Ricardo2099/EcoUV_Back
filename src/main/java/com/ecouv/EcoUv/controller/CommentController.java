package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.CreateCommentRequest;
import com.ecouv.EcoUv.model.Comentario;
import com.ecouv.EcoUv.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody CreateCommentRequest req) {
        return ResponseEntity.ok(commentService.crearComentario(req));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<Comentario>> obtenerComentarios(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.obtenerComentarios(id));
    }
}
