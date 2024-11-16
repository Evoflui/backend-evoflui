package com.proact.evoflui_backend.Repository.Evento;

import com.proact.evoflui_backend.Model.Evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
