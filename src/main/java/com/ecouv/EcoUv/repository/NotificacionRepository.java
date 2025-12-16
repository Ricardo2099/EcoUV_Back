package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Notificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    Page<Notificacion> findByDestinatarioIdOrderByCreadoEnDesc(Long destinatarioId, Pageable pageable);

    long countByDestinatarioIdAndLeidaFalse(Long destinatarioId);
}
