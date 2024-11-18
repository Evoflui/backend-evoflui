package com.proact.evoflui_backend.Model.Novel;

import com.proact.evoflui_backend.Model.Trilha.Atividade;
import jakarta.persistence.*;

@Entity
@Table(name="escolha")
public class Escolha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "escolha_id")
    private Long escolhaId;

    @Column(name="opcao")
    private String nomeOpcao;

    @Column(name="foto_opcao")
    private String fotoOpcao;

    @Column(name="valor_relacionamento")
    private int valorRelacionamento;

    @ManyToOne
    @JoinColumn(name = "cena_id",  referencedColumnName = "cena_id")
    private Cena forCena;

    @ManyToOne
    @JoinColumn(name = "atividade_id",  referencedColumnName = "atividade_id")
    private Atividade forAtividade;

    public Escolha() {}

    public Escolha(String nomeOpcao, String fotoOpcao, int valorRelacionamento, Cena forCena, Atividade forAtividade) {
        this.nomeOpcao = nomeOpcao;
        this.fotoOpcao = fotoOpcao;
        this.valorRelacionamento = valorRelacionamento;
        this.forCena = forCena;
        this.forAtividade = forAtividade;
    }

    public Long getEscolhaId() {return escolhaId;}

    public String getNomeOpcao() {return nomeOpcao;}

    public void setNomeOpcao(String nomeOpcao) {this.nomeOpcao = nomeOpcao;}

    public int getValorRelacionamento() {return valorRelacionamento;}

    public void setValorRelacionamento(int valorRelacionamento) {this.valorRelacionamento = valorRelacionamento;}

    public String getFotoOpcao() {return fotoOpcao;}

    public void setFotoOpcao(String fotoOpcao) {this.fotoOpcao = fotoOpcao;}

    public Cena getForCena() {return forCena;}

    public void setForCena(Cena forCena) {this.forCena = forCena;}

    public Atividade getForAtividade() {return forAtividade;}

    public void setForAtividade(Atividade forAtividade) {this.forAtividade = forAtividade;}
}
