package com.proact.evoflui_backend.Repository.Cena;

import com.proact.evoflui_backend.Model.Novel.Cena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenaRepository extends JpaRepository<Cena, Long> {
}
