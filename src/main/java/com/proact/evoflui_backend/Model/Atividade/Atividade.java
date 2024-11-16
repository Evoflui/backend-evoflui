package com.proact.evoflui_backend.Model.Atividade;

import com.proact.evoflui_backend.Enums.StatusAtividade;
import jakarta.persistence.*;

@Entity
@Table(name="atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    private int atividadeId;

    @Column(name="titulo")
    private String titulo;

    @Column(name="enunciado")
    private String enunciado;

    @Column(name="desafio")
    private String desafio;

    @Column(name="resposta")
    private String resposta;

    @Column(name="status_atividade")
    @Enumerated(EnumType.STRING)
    private StatusAtividade statusAtividade;

    @Column(name="bloco_id")
    private int blocoId;

    public Atividade() {
    }

    public Atividade(int atividadeId, String titulo, String enunciado, String desafio, String resposta, StatusAtividade statusAtividade, int blocoId) {
        this.atividadeId = atividadeId;
        this.titulo = titulo;
        this.enunciado = enunciado;
        this.desafio = desafio;
        this.resposta = resposta;
        this.statusAtividade = statusAtividade;
        this.blocoId = blocoId;
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getDesafio() {
        return desafio;
    }

    public void setDesafio(String desafio) {
        this.desafio = desafio;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public int getBlocoId() {
        return blocoId;
    }

    public void setBlocoId(int blocoId) {
        this.blocoId = blocoId;
    }
}
