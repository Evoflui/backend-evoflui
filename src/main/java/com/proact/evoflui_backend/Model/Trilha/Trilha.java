package com.proact.evoflui_backend.Model.Trilha;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proact.evoflui_backend.Enums.StatusTrilha;
import com.proact.evoflui_backend.Enums.StatusTipoUsuario;
import com.proact.evoflui_backend.Model.Novel.Cena;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="trilha")
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trilha_id")
    private Long trilhaId;

    @Column(name="titulo_trilha", nullable = false)
    private String tituloTrilha;

    @Column(name="tipo_id")
    private Long tipoTrilha;

    @Column(name="status_trilha")
    @Enumerated(EnumType.STRING)
    private StatusTrilha statusTrilha;

    @JsonManagedReference
    @OneToMany(mappedBy = "forTrilha", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bloco> blocosTrilha;

    @JsonManagedReference
    @OneToMany(mappedBy = "forTrilha", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cena> cenasTrilha;

    public Trilha() {}

    public Trilha(String tituloTrilha, Long tipoTrilha, StatusTrilha statusTrilha, List<Bloco> blocosTrilha, List<Cena> cenasTrilha) {
        this.tituloTrilha = tituloTrilha;
        this.tipoTrilha = tipoTrilha;
        this.statusTrilha = statusTrilha;
        this.blocosTrilha = blocosTrilha;
        this.cenasTrilha = cenasTrilha;
    }

    public Long getTrilhaId() {return trilhaId;}

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
