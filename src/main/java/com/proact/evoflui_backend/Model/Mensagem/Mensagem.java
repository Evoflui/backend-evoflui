package com.proact.evoflui_backend.Model.Mensagem;


import jakarta.persistence.*;
import java.util.Date;
import java.time.LocalTime;

@Entity
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensagem_id")
    private int mensagemId;

    @Column(name = "topico_id")
    private int topicoId;

    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "data_postagem")
    private Date dataPostagem;

    @Column(name = "hora_postagem")
    private LocalTime horaPostagem;

    @Column(name = "texto")
    private String texto;


    public Mensagem() {
    }

    public Mensagem(int topicoId, int usuarioId, Date dataPostagem, LocalTime horaPostagem, String texto) {
        this.topicoId = topicoId;
        this.usuarioId = usuarioId;
        this.dataPostagem = dataPostagem;
        this.horaPostagem = horaPostagem;
        this.texto = texto;
    }

    public int getMensagemId() {
        return mensagemId;
    }

    public void setMensagemId(int mensagemId) {
        this.mensagemId = mensagemId;
    }

    public int getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(int topicoId) {
        this.topicoId = topicoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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
