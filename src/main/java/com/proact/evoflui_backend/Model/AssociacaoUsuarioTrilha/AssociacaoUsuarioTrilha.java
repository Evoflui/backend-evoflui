package com.proact.evoflui_backend.Model.AssociacaoUsuarioTrilha;

import jakarta.persistence.*;

@Entity
@Table(name="associacao_usuario_trilha")
public class AssociacaoUsuarioTrilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name="trilha_id")
    private int trilhaId;

    public AssociacaoUsuarioTrilha() {
    }

    public AssociacaoUsuarioTrilha(int trilhaId) {
        this.trilhaId = trilhaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(int trilhaId) {
        this.trilhaId = trilhaId;
    }
}
