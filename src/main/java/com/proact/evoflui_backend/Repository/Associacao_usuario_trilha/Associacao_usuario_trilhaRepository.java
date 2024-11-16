package com.proact.evoflui_backend.Repository.Associacao_usuario_trilha;

import com.proact.evoflui_backend.Model.Associacao_usuario_trilha.Associacao_usuario_trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Associacao_usuario_trilhaRepository extends JpaRepository<Associacao_usuario_trilha, Long> {
}
