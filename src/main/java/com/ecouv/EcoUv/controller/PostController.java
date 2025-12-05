package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.CrearPostRequest;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> crearPost(@RequestBody CrearPostRequest request) {
        return ResponseEntity.ok(postService.crearPost(request));
    }

    @GetMapping("/grupo/{id}")
    public ResponseEntity<List<Post>> feedGrupo(@PathVariable Long id) {
        return ResponseEntity.ok(postService.feedGrupo(id));
    }

    @GetMapping("/carrera/{id}")
    public ResponseEntity<List<Post>> feedCarrera(@PathVariable Long id) {
        return ResponseEntity.ok(postService.feedCarrera(id));
    }

    @GetMapping("/plan/{id}")
    public ResponseEntity<List<Post>> feedPlan(@PathVariable Long id) {
        return ResponseEntity.ok(postService.feedPlan(id));
    }

    @GetMapping("/facultad/{id}")
    public ResponseEntity<List<Post>> feedFacultad(@PathVariable Long id) {
        return ResponseEntity.ok(postService.feedFacultad(id));
    }

    @GetMapping("/semestre/{sem}")
    public ResponseEntity<List<Post>> feedSemestre(@PathVariable Integer sem) {
        return ResponseEntity.ok(postService.feedSemestre(sem));
    }
}
