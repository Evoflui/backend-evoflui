package com.proact.evoflui_backend.Repository.Usuario;

import com.proact.evoflui_backend.Model.Usuario.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
