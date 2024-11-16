package com.proact.evoflui_backend.Model.Bloco;

import jakarta.persistence.*;

@Entity
@Table(name="bloco")
public class Bloco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloco_id")
    private int blocoId;

    @Column(name="titulo")
    private String titulo;

    @Column(name="is_bloqueado")
    private Boolean isBloqueado;

    @Column(name="trilha_id")
    private int trilhaId;

    public Bloco() {
    }

    public Bloco(String titulo, Boolean isBloqueado, int trilhaId) {
        this.titulo = titulo;
        this.isBloqueado = isBloqueado;
        this.trilhaId = trilhaId;
    }

    public int getBlocoId() {
        return blocoId;
    }

    public void setBlocoId(int blocoId) {
        this.blocoId = blocoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getBloqueado() {
        return isBloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        isBloqueado = bloqueado;
    }

    public int getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(int trilhaId) {
        this.trilhaId = trilhaId;
    }
}
