package com.proact.evoflui_backend.Model.Novel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proact.evoflui_backend.DTO.VisualNovel.RelacionamentoUsuarioPersonagemDTO;
import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "forPersonagem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RelacionamentoUsuarioPersonagem> forRelacionamentoPersonagem;

    @Column(name = "cor_personagem")
    private String corPersonagem;

    public Personagem() {
    }

    public Personagem(String fotoPersonagem, String nomePersonagem, List<RelacionamentoUsuarioPersonagem> forRelacionamentoPersonagem, String corPersonagem) {
        this.fotoPersonagem = fotoPersonagem;
        this.nomePersonagem = nomePersonagem;
        this.forRelacionamentoPersonagem = forRelacionamentoPersonagem;
        this.corPersonagem = corPersonagem;
    }

    public Long getPersonagemId() {return personagemId;}

    public String getFotoPersonagem() {return fotoPersonagem;}

    public void setFotoPersonagem(String fotoPersonagem) {this.fotoPersonagem = fotoPersonagem;}

    public String getNomePersonagem() {return nomePersonagem;}

    public void setNomePersonagem(String nomePersonagem) {this.nomePersonagem = nomePersonagem;}

    public List<RelacionamentoUsuarioPersonagem> getForRelacionamentoPersonagem() {
        return forRelacionamentoPersonagem;
    }

    public void setForRelacionamentoPersonagem(List<RelacionamentoUsuarioPersonagem> forRelacionamentoPersonagem) {
        this.forRelacionamentoPersonagem = forRelacionamentoPersonagem;
    }

    public String getCorPersonagem() {
        return corPersonagem;
    }

    public void setCorPersonagem(String corPersonagem) {
        this.corPersonagem = corPersonagem;
    }
}
