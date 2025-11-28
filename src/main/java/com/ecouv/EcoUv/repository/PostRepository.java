package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Feed: posts de un grupo, más recientes primero
    List<Post> findByGrupoOrderByCreadoEnDesc(Grupo grupo);

    // "Mis publicaciones"
    List<Post> findByAutorOrderByCreadoEnDesc(User autor);

    // Feed por carrera (toda la carrera, sin filtrar semestre)
    List<Post> findByGrupo_CarreraOrderByCreadoEnDesc(Carrera carrera);

    // Feed por carrera + semestre (ej. Ing. Software, 3er semestre)
    List<Post> findByGrupo_CarreraAndGrupo_SemestreOrderByCreadoEnDesc(Carrera carrera, Integer semestre);
}
