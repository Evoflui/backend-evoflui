package com.proact.evoflui_backend.Repository.Atividade;

import com.proact.evoflui_backend.Model.Atividade.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
