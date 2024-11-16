package com.proact.evoflui_backend.Model.Associacao_usuario_trilha;

import jakarta.persistence.*;

@Entity
@Table(name="associacao_usuario_trilha")
public class Associacao_usuario_trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name="trilha_id")
    private int trilhaId;

    public Associacao_usuario_trilha() {
    }

    public Associacao_usuario_trilha(int trilhaId) {
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
