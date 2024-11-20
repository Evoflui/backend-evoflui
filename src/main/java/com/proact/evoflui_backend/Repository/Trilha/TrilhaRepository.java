package com.proact.evoflui_backend.Repository.Trilha;

import com.proact.evoflui_backend.Model.Trilha.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Long> {

    public Trilha findByTipoTrilha(Long tipoTrilha);
}
