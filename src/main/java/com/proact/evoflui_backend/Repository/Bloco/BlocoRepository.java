package com.proact.evoflui_backend.Repository.Bloco;

import com.proact.evoflui_backend.Model.Bloco.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {
}
