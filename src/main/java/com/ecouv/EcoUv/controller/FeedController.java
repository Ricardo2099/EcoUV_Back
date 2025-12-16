package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.dto.PostResponseDTO;
import com.ecouv.EcoUv.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    private final PostService postService;

    public FeedController(PostService postService) {
        this.postService = postService;
    }

    // GET /api/feed?userId=1&page=0&size=20
    @GetMapping
    public Page<PostResponseDTO> feedMixto(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return postService.feedMixtoPorUsuario(userId, page, size);
    }
}
