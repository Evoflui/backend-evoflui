package com.proact.evoflui_backend.Model.Trilha;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proact.evoflui_backend.Enums.StatusAtividade;
import com.proact.evoflui_backend.Model.Novel.Cena;
import com.proact.evoflui_backend.Model.Novel.Escolha;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    private Long atividadeId;

    @Column(name="titulo_atividade")
    private String tituloAtividade;

    @Column(name="enunciado_atividade")
    private String enunciadoAtividade;

    @Column(name = "escolha_id")
    private Long respostaAtividade;

    @Column(name="status_atividade")
    @Enumerated(EnumType.STRING)
    private StatusAtividade statusAtividade;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "bloco_id", nullable = false)
    private Bloco forBloco;

    @JsonManagedReference
    @OneToMany(mappedBy = "forAtividade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Escolha> opcoesAtividade;

    @JsonManagedReference
    @OneToMany(mappedBy = "forAtividade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cena> cenasAtividade;

    public Atividade() {}

    public Atividade(String tituloAtividade, String enunciadoAtividade, Long respostaAtividade, StatusAtividade statusAtividade, Bloco bloco, List<Escolha> opcoesAtividade, List<Cena> cenasAtividade) {
        this.tituloAtividade = tituloAtividade;
        this.enunciadoAtividade = enunciadoAtividade;
        this.respostaAtividade = respostaAtividade;
        this.statusAtividade = statusAtividade;
        this.forBloco = bloco;
        this.opcoesAtividade = opcoesAtividade;
        this.cenasAtividade = cenasAtividade;
    }

    public Long getAtividadeId() {return atividadeId;}

    public String getTituloAtividade() {return tituloAtividade;}

    public void setTituloAtividade(String tituloAtividade) {this.tituloAtividade = tituloAtividade;}

    public String getEnunciadoAtividade() {return enunciadoAtividade;}

    public void setEnunciadoAtividade(String enunciadoAtividade) {this.enunciadoAtividade = enunciadoAtividade;}

    public Long getRespostaAtividade() {return respostaAtividade;}

    public void setRespostaAtividade(Long respostaAtividade) {this.respostaAtividade = respostaAtividade;}

    public StatusAtividade getStatusAtividade() {return statusAtividade;}

    public void setStatusAtividade(StatusAtividade statusAtividade) {this.statusAtividade = statusAtividade;}

    public Bloco getBloco() {return forBloco;}

    public void setBloco(Bloco bloco) {this.forBloco = bloco;}

    public List<Escolha> getOpcoesAtividade() {return opcoesAtividade;}

    public void setOpcoesAtividade(List<Escolha> opcoesAtividade) {this.opcoesAtividade = opcoesAtividade;}

    public List<Cena> getCenasAtividade() {return cenasAtividade;}

    public void setCenasAtividade(List<Cena> cenasAtividade) {this.cenasAtividade = cenasAtividade;}
}
