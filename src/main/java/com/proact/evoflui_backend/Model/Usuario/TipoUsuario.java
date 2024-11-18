package com.proact.evoflui_backend.Model.Usuario;

import com.proact.evoflui_backend.Enums.StatusTipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
    @Id
    @Column(name = "tipo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoId;

    @Column(nullable = false, unique = true, name = "nome_tipo")
    @Enumerated(EnumType.STRING)
    private StatusTipoUsuario nomeTipo;

    public TipoUsuario() {}

    public TipoUsuario(StatusTipoUsuario nomeTipo) {this.nomeTipo = nomeTipo;}

    public Long getTipoId() {return tipoId;}

    public StatusTipoUsuario getNomeTipo() {return nomeTipo;}

    public void setNomeTipo(StatusTipoUsuario nomeTipo) {this.nomeTipo = nomeTipo;}
}
