package com.proact.evoflui_backend.Repository.Topico;


import com.proact.evoflui_backend.Model.Topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
