package com.proact.evoflui_backend.Model.Trilha;

import com.proact.evoflui_backend.Enums.StatusTrilha;
import com.proact.evoflui_backend.Enums.StatusTipoUsuario;
import com.proact.evoflui_backend.Model.Novel.Cena;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="trilha")
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trilha_id")
    private int trilhaId;

    @Column(name="titulo_trilha", nullable = false)
    private String tituloTrilha;

    @Column(name="tipo_id")
    private Long tipoTrilha;

    @Column(name="status_trilha")
    @Enumerated(EnumType.STRING)
    private StatusTrilha statusTrilha;

    @OneToMany(mappedBy = "forTrilha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bloco> blocosTrilha;

    @OneToMany(mappedBy = "forTrilha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cena> cenasTrilha;

    public Trilha() {}

    public Trilha(String tituloTrilha, Long tipoTrilha, StatusTrilha statusTrilha, List<Bloco> blocosTrilha, List<Cena> cenasTrilha) {
        this.tituloTrilha = tituloTrilha;
        this.tipoTrilha = tipoTrilha;
        this.statusTrilha = statusTrilha;
        this.blocosTrilha = blocosTrilha;
        this.cenasTrilha = cenasTrilha;
    }

    public int getTrilhaId() {return trilhaId;}

    public String getTituloTrilha() {return tituloTrilha;}

    public void setTituloTrilha(String tituloTrilha) {this.tituloTrilha = tituloTrilha;}

    public Long getTipoTrilha() {return tipoTrilha;}

    public void setTipoTrilha(Long tipoTrilha) {this.tipoTrilha = tipoTrilha;}

    public StatusTrilha getStatusTrilha() {return statusTrilha;}

    public void setStatusTrilha(StatusTrilha statusTrilha) {this.statusTrilha = statusTrilha;}

    public List<Bloco> getBlocosTrilha() {return blocosTrilha;}

    public void setBlocosTrilha(List<Bloco> blocosTrilha) {this.blocosTrilha = blocosTrilha;}

    public List<Cena> getCenasTrilha() {return cenasTrilha;}

    public void setCenasTrilha(List<Cena> cenasTrilha) {this.cenasTrilha = cenasTrilha;}
}
