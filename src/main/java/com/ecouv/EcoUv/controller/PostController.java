package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.*;
import com.ecouv.EcoUv.model.Comentario;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.service.PostService;
import com.ecouv.EcoUv.service.ReaccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final ReaccionService reaccionService;

    /**
     * Crear un post nuevo.
     * El front manda el autorId (id del User) y el contenido.
     */
    @PostMapping
    public ResponseEntity<PostDTO> crearPost(@Valid @RequestBody CreatePostRequest req) {
        Post post = postService.crearPost(req);
        long likes = reaccionService.contarReaccionesDePost(post.getId());
        PostDTO dto = PostDTO.of(post, likes);
        return ResponseEntity.ok(dto);
    }

    /**
     * Feed por GRUPO (muro del salón actual del usuario).
     * GET /api/posts/feed?userId=1
     */
    @GetMapping("/feed")
    public ResponseEntity<List<PostDTO>> feedPorGrupo(@RequestParam Long userId) {
        List<Post> posts = postService.feedDeUsuarioPorGrupo(userId);
        List<PostDTO> dtos = posts.stream()
                .map(p -> PostDTO.of(p, reaccionService.contarReaccionesDePost(p.getId())))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    /**
     * Feed por CARRERA (todos los grupos y semestres de la misma carrera).
     * GET /api/posts/feed/carrera?userId=1
     */
    @GetMapping("/feed/carrera")
    public ResponseEntity<List<PostDTO>> feedPorCarrera(@RequestParam Long userId) {
        List<Post> posts = postService.feedDeUsuarioPorCarrera(userId);
        List<PostDTO> dtos = posts.stream()
                .map(p -> PostDTO.of(p, reaccionService.contarReaccionesDePost(p.getId())))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    /**
     * Feed por CARRERA + SEMESTRE.
     * Ej: todos los posts de 3er semestre de Ingeniería de Software.
     * GET /api/posts/feed/carrera-semestre?userId=1
     */
    @GetMapping("/feed/carrera-semestre")
    public ResponseEntity<List<PostDTO>> feedPorCarreraYSemestre(@RequestParam Long userId) {
        List<Post> posts = postService.feedDeUsuarioPorCarreraYSemestre(userId);
        List<PostDTO> dtos = posts.stream()
                .map(p -> PostDTO.of(p, reaccionService.contarReaccionesDePost(p.getId())))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    /**
     * Mis publicaciones: posts creados por el usuario.
     * GET /api/posts/mios?userId=1
     */
    @GetMapping("/mios")
    public ResponseEntity<List<PostDTO>> misPosts(@RequestParam Long userId) {
        List<Post> posts = postService.postsDeUsuario(userId);
        List<PostDTO> dtos = posts.stream()
                .map(p -> PostDTO.of(p, reaccionService.contarReaccionesDePost(p.getId())))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    /**
     * Crear comentario en un post.
     * POST /api/posts/{postId}/comentarios
     */
    @PostMapping("/{postId}/comentarios")
    public ResponseEntity<CommentResponse> comentar(
            @PathVariable Long postId,
            @Valid @RequestBody CreateCommentRequest req
    ) {
        Comentario c = postService.crearComentario(postId, req);
        return ResponseEntity.ok(CommentResponse.fromEntity(c));
    }

    /**
     * Listar comentarios de un post.
     * GET /api/posts/{postId}/comentarios
     */
    @GetMapping("/{postId}/comentarios")
    public ResponseEntity<List<CommentResponse>> comentarios(@PathVariable Long postId) {
        List<Comentario> comentarios = postService.comentariosDePost(postId);
        List<CommentResponse> dtos = comentarios.stream()
                .map(CommentResponse::fromEntity)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    /**
     * Toggle de reacción (like/corazón).
     * POST /api/posts/{postId}/reacciones/toggle?userId=1
     * Devuelve el nuevo conteo de likes.
     */
    @PostMapping("/{postId}/reacciones/toggle")
    public ResponseEntity<Long> toggleReaccion(
            @PathVariable Long postId,
            @RequestParam Long userId
    ) {
        long total = reaccionService.toggleReaccion(postId, userId);
        return ResponseEntity.ok(total);
    }

    /**
     * Obtener número de reacciones de un post.
     * GET /api/posts/{postId}/reacciones/count
     */
    @GetMapping("/{postId}/reacciones/count")
    public ResponseEntity<Long> contarReacciones(@PathVariable Long postId) {
        long total = reaccionService.contarReaccionesDePost(postId);
        return ResponseEntity.ok(total);
    }
}
