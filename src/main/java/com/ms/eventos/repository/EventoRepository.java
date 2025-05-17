package com.ms.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ms.eventos.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
        boolean existsByDescripcion(String descripcion);
}
