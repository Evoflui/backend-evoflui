package com.proact.evoflui_backend.Model.Resposta;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="resposta")

public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resposta_id")
    private int respostaId;

    @Column(name= "mensagem_id")
    private int mensagemId;

    @Column(name="data_postagem")
    private Date dataPostagem;

    @Column(name="hora_postagem")
    private LocalTime horaPostagem;

    @Column(name="texto")
    private String texto;

    public Resposta() {
    }

    public Resposta(int mensagemId, Date dataPostagem, LocalTime horaPostagem, String texto) {
        this.mensagemId = mensagemId;
        this.dataPostagem = dataPostagem;
        this.horaPostagem = horaPostagem;
        this.texto = texto;
    }

    public int getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }

    public int getMensagemId() {
        return mensagemId;
    }

    public void setMensagemId(int mensagemId) {
        this.mensagemId = mensagemId;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public LocalTime getHoraPostagem() {
        return horaPostagem;
    }

    public void setHoraPostagem(LocalTime horaPostagem) {
        this.horaPostagem = horaPostagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

