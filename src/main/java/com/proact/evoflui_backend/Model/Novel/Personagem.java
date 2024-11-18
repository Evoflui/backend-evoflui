package com.proact.evoflui_backend.Model.Novel;

import jakarta.persistence.*;

@Entity
@Table(name="personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personagem_id")
    private Long personagemId;

    @Column(name="foto_personagem", nullable = false)
    private String fotoPersonagem;

    @Column(name="nome_personagem", nullable = false)
    private String nomePersonagem;

    public Personagem() {
    }

    public Personagem(String fotoPersonagem, String nomePersonagem) {
        this.fotoPersonagem = fotoPersonagem;
        this.nomePersonagem = nomePersonagem;
    }

    public Long getPersonagemId() {return personagemId;}

    public String getFotoPersonagem() {return fotoPersonagem;}

    public void setFotoPersonagem(String fotoPersonagem) {this.fotoPersonagem = fotoPersonagem;}

    public String getNomePersonagem() {return nomePersonagem;}

    public void setNomePersonagem(String nomePersonagem) {this.nomePersonagem = nomePersonagem;}
}
