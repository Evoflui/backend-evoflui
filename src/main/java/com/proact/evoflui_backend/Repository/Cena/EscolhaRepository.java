package com.proact.evoflui_backend.Repository.Cena;

import com.proact.evoflui_backend.Model.Novel.Escolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolhaRepository extends JpaRepository<Escolha, Long> {

}
