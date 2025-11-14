package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDTO {
  private Long id;
  private String autor;
  private String contenido;
  private LocalDateTime creadoEn; 
  private long likes;

  public static PostDTO of(Post p, long likes){
    return new PostDTO(
        p.getId(),
        p.getAutor().getNombre(),
        p.getContenido(),
        p.getCreadoEn(),   
        likes
    );
  }
}
