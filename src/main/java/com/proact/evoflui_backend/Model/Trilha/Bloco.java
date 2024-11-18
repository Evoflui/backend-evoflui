package com.proact.evoflui_backend.Model.Trilha;

import com.proact.evoflui_backend.Model.Novel.Cena;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bloco")
public class Bloco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloco_id")
    private int blocoId;

    @Column(name="titulo_bloco", nullable = false)
    private String tituloBloco;

    @Column(name="is_bloqueado")
    private Boolean isBloqueado;

    @ManyToOne
    @JoinColumn(name = "trilha_id", referencedColumnName = "trilha_id", insertable = false, updatable = false)
    private Trilha forTrilha;  // Propriedade que faz o relacionamento bidirecional

    @OneToMany(mappedBy = "forBloco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividadesBloco;

    @OneToMany(mappedBy = "forBloco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cena> cenasBloco;

    public Bloco() {}

    public Bloco(String tituloBloco, Boolean isBloqueado, Trilha forTrilha, List<Atividade> atividadesBloco, List<Cena> cenasBloco) {
        this.tituloBloco = tituloBloco;
        if(isBloqueado == null) {
            this.isBloqueado = Boolean.FALSE;
        } else {
            this.isBloqueado = isBloqueado;
        }
        this.forTrilha = forTrilha;
        this.atividadesBloco = atividadesBloco;
        this.cenasBloco = cenasBloco;
    }

    public int getBlocoId() {return blocoId;}

    public String getTituloBloco() {return tituloBloco;}

    public void setTituloBloco(String tituloBloco) {this.tituloBloco = tituloBloco;}

    public Boolean getBloqueado() {return isBloqueado;}

    public void setBloqueado(Boolean bloqueado) {isBloqueado = bloqueado;}

    public Trilha getForTrilha() {return forTrilha;}

    public void setForTrilha(Trilha forTrilha) {this.forTrilha = forTrilha;}

    public List<Atividade> getAtividadesBloco() {return atividadesBloco;}

    public void setAtividadesBloco(List<Atividade> atividadesBloco) {this.atividadesBloco = atividadesBloco;}

    public List<Cena> getCenasBloco() {return cenasBloco;}

    public void setCenasBloco(List<Cena> cenasBloco) {this.cenasBloco = cenasBloco;}
}
