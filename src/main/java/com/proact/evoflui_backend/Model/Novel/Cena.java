package com.proact.evoflui_backend.Model.Novel;

import com.proact.evoflui_backend.Model.Trilha.Atividade;
import com.proact.evoflui_backend.Model.Trilha.Bloco;
import com.proact.evoflui_backend.Model.Trilha.Trilha;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cena")
public class Cena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cena_id")
    private int cenaId;

    @Column(name="frase_cena", nullable = false)
    private String fraseCena;

    @Column(name = "personagem_id")
    private Long personagemCena;

    @OneToMany(mappedBy = "forCena", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Escolha> escolhasCena;

    @ManyToOne
    @JoinColumn(name = "trilha_id", referencedColumnName = "trilha_id")
    private Trilha forTrilha;

    @ManyToOne
    @JoinColumn(name = "bloco_id", referencedColumnName = "bloco_id")
    private Bloco forBloco;

    @ManyToOne
    @JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")
    private Atividade forAtividade;

    public Cena() {}

    public Cena(String fraseCena, Long personagemCena, List<Escolha> escolhasCena, Trilha forTrilha, Bloco forBloco, Atividade forAtividade) {
        this.fraseCena = fraseCena;
        this.personagemCena = personagemCena;
        this.escolhasCena = escolhasCena;
        this.forTrilha = forTrilha;
        this.forBloco = forBloco;
        this.forAtividade = forAtividade;
    }

    public int getCenaId() {return cenaId;}

    public String getFraseCena() {return fraseCena;}

    public void setFraseCena(String fraseCena) {this.fraseCena = fraseCena;}

    public Long getPersonagemCena() {return personagemCena;}

    public void setPersonagemCena(Long personagemCena) {this.personagemCena = personagemCena;}

    public Bloco getForBloco() {return forBloco;}

    public void setForBloco(Bloco forBloco) {this.forBloco = forBloco;}

    public Atividade getForAtividade() {return forAtividade;}

    public void setForAtividade(Atividade forAtividade) {this.forAtividade = forAtividade;}

    public List<Escolha> getEscolhasCena() {return escolhasCena;}

    public void setEscolhasCena(List<Escolha> escolhasCena) {this.escolhasCena = escolhasCena;}

    public Trilha getForTrilha() {return forTrilha;}

    public void setForTrilha(Trilha forTrilha) {this.forTrilha = forTrilha;}
}
