package com.proact.evoflui_backend.Repository.Cena;

import com.proact.evoflui_backend.Model.Novel.Personagem;
import com.proact.evoflui_backend.Model.Novel.RelacionamentoUsuarioPersonagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelacionamentoUsuarioPersonagemRepository extends JpaRepository<RelacionamentoUsuarioPersonagem, Long>  {
}
