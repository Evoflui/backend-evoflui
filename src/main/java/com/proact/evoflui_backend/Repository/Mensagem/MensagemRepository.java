package com.proact.evoflui_backend.Repository.Mensagem;

import com.proact.evoflui_backend.Model.Mensagem.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
