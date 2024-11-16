package com.proact.evoflui_backend.Model.Evento;

import com.proact.evoflui_backend.Enums.StatusEvento;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="evento")

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private int eventoId;

    @Column(name="usuario_id")
    private int usuarioId;

    @Column(name="data")
    private Date data;

    @Column(name="horas")
    private LocalTime hora;

    @Column(name="direcionamento")
    private String direcionamento;

    @Column(name="vagas_disponiveis")
    private int vagasDisponiveis;

    @Column(name="inscricao_de_eventos")
    private int inscricaoDeEventos;

    @Column(name="localizacao")
    private String localizacao;

    @Column(name="status_evento")
    @Enumerated(EnumType.STRING)
    private StatusEvento statusEvento;

    public Evento() {
    }

    public Evento(int usuarioId, Date data, LocalTime hora, String direcionamento, int vagasDisponiveis, int inscricaoDeEventos, String localizacao, StatusEvento statusEvento) {
        this.usuarioId = usuarioId;
        this.data = data;
        this.hora = hora;
        this.direcionamento = direcionamento;
        this.vagasDisponiveis = vagasDisponiveis;
        this.inscricaoDeEventos = inscricaoDeEventos;
        this.localizacao = localizacao;
        this.statusEvento = statusEvento;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDirecionamento() {
        return direcionamento;
    }

    public void setDirecionamento(String direcionamento) {
        this.direcionamento = direcionamento;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getInscricaoDeEventos() {
        return inscricaoDeEventos;
    }

    public void setInscricaoDeEventos(int inscricaoDeEventos) {
        this.inscricaoDeEventos = inscricaoDeEventos;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public StatusEvento getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(StatusEvento statusEvento) {
        this.statusEvento = statusEvento;
    }
}
