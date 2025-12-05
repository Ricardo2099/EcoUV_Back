package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.ReaccionRequest;
import com.ecouv.EcoUv.model.Reaccion;
import com.ecouv.EcoUv.service.ReaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reacciones")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ReaccionController {

    private final ReaccionService reaccionService;

    @PostMapping("/like")
    public ResponseEntity<Reaccion> darLike(@RequestBody ReaccionRequest req) {
        return ResponseEntity.ok(reaccionService.darLike(req));
    }

    @DeleteMapping("/like/{usuarioId}/{postId}")
    public ResponseEntity<?> quitarLike(@PathVariable Long usuarioId, @PathVariable Long postId) {
        reaccionService.quitarLike(usuarioId, postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Integer> contarLikes(@PathVariable Long postId) {
        return ResponseEntity.ok(reaccionService.contarLikes(postId));
    }
}
