package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.CrearPostRequest;
import com.ecouv.EcoUv.dto.PostResponseDTO;
import com.ecouv.EcoUv.service.PostService;
import com.ecouv.EcoUv.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CloudinaryService cloudinaryService;

    // ==========================
    // CRUD BÁSICO DE POSTS
    // ==========================

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

    // ==========================
    // SUBIR IMAGEN (CLOUDINARY)
    // ==========================

    @PostMapping("/upload-imagen")
    public ResponseEntity<String> uploadImagen(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("El archivo está vacío");
        }

        String url = cloudinaryService.uploadImage(file);
        return ResponseEntity.ok(url);
    }

    // ==========================
    // FEEDS POR CATEGORIA
    // ==========================

    // Feed por grupo
    @GetMapping("/grupo/{grupoId}")
    public List<PostResponseDTO> feedGrupo(
            @PathVariable Long grupoId,
            @RequestParam String tipoFeed
    ) {
        return postService.listarPorGrupo(grupoId, tipoFeed);
    }

    // Feed por carrera
    @GetMapping("/carrera/{carreraId}")
    public List<PostResponseDTO> feedCarrera(
            @PathVariable Long carreraId,
            @RequestParam String tipoFeed
    ) {
        return postService.listarPorCarrera(carreraId, tipoFeed);
    }

    // Feed por plan
    @GetMapping("/plan/{planId}")
    public List<PostResponseDTO> feedPlan(
            @PathVariable Long planId,
            @RequestParam String tipoFeed
    ) {
        return postService.listarPorPlan(planId, tipoFeed);
    }

    // Feed por facultad
    @GetMapping("/facultad/{facultadId}")
    public List<PostResponseDTO> feedFacultad(
            @PathVariable Long facultadId,
            @RequestParam String tipoFeed
    ) {
        return postService.listarPorFacultad(facultadId, tipoFeed);
    }

    // Feed por semestre
    @GetMapping("/semestre/{semestre}")
    public List<PostResponseDTO> feedSemestre(
            @PathVariable Integer semestre,
            @RequestParam String tipoFeed
    ) {
        return postService.listarPorSemestre(semestre, tipoFeed);
    }
}
