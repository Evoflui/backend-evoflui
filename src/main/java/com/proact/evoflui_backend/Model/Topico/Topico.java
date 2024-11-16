package com.proact.evoflui_backend.Model.Topico;

import jakarta.persistence.*;

@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topico_id")
    private int topicoId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "quantidade_mensagem")
    private int quantidadeMensagem;


    public Topico() {
    }

    public Topico(String titulo, int quantidadeMensagem) {

        this.titulo = titulo;
        this.quantidadeMensagem = quantidadeMensagem;
    }

    public int getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(int topicoId) {
        this.topicoId = topicoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidadeMensagem() {
        return quantidadeMensagem;
    }

    public void setQuantidadeMensagem(int quantidadeMensagem) {
        this.quantidadeMensagem = quantidadeMensagem;
    }
}
