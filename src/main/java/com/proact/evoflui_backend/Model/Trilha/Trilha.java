package com.proact.evoflui_backend.Model.Trilha;

import com.proact.evoflui_backend.Enums.StatusEvento;
import com.proact.evoflui_backend.Enums.StatusTipoTrilha;
import com.proact.evoflui_backend.Enums.StatusTrilha;
import jakarta.persistence.*;

@Entity
@Table(name="trilha")
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trilha_id")
    private int trilhaId;

    @Column(name="titulo")
    private String titulo;

    @Column(name="tipo_trilha")
    @Enumerated(EnumType.STRING)
    private StatusTipoTrilha tipoTrilha;

    @Column(name="status_trilha")
    @Enumerated(EnumType.STRING)
    private StatusTrilha statusTrilha;

    public Trilha() {
    }

    public Trilha(String titulo, StatusTipoTrilha tipoTrilha, StatusTrilha statusTrilha) {
        this.titulo = titulo;
        this.tipoTrilha = tipoTrilha;
        this.statusTrilha = statusTrilha;
    }

    public int getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(int trilhaId) {
        this.trilhaId = trilhaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public StatusTipoTrilha getTipoTrilha() {
        return tipoTrilha;
    }

    public void setTipoTrilha(StatusTipoTrilha tipoTrilha) {
        this.tipoTrilha = tipoTrilha;
    }

    public StatusTrilha getStatusTrilha() {
        return statusTrilha;
    }

    public void setStatusTrilha(StatusTrilha statusTrilha) {
        this.statusTrilha = statusTrilha;
    }
}
