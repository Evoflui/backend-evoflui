package com.proact.evoflui_backend.Repository.Resposta;

import com.proact.evoflui_backend.Model.Resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
