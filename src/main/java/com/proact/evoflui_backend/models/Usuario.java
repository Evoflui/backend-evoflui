package com.proact.evoflui_backend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

//    @Column(unique = true)
//    private Eventos eventosInscrito;

//    @Column(name = "tipo_plano")
//    private TipoPlano tipoPlano;

//    @ManyToOne
//    @JoinColumn(name = "tipo_usuario_id", nullable = false)
//    private TipoUsuario tipoUsuario;

    @Column(name = "progresso_trilha", columnDefinition = "INT DEFAULT 0")
    private Integer progressoTrilha = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_usuario")
    private Status statusUsuario;

    public Usuario() {}

    public Usuario(Long usuarioId, String nome, String sobrenome, Integer inscricaoDeEventos, Integer tipoPlano, Integer progressoTrilha, Status statusUsuario) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.sobrenome = sobrenome;
//        this.inscricaoDeEventos = inscricaoDeEventos;
//        this.tipoPlano = tipoPlano;
//        this.tipoUsuario = tipoUsuario;
        this.progressoTrilha = progressoTrilha;
        this.statusUsuario = statusUsuario;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }
//
//    public Integer getInscricaoDeEventos() {
//        return inscricaoDeEventos;
//    }
//
//    public void setInscricaoDeEventos(Integer inscricaoDeEventos) {
//        this.inscricaoDeEventos = inscricaoDeEventos;
//    }
//
//    public Integer getTipoPlano() {
//        return tipoPlano;
//    }
//
//    public void setTipoPlano(Integer tipoPlano) {
//        this.tipoPlano = tipoPlano;
//    }

//    public TipoUsuario getTipoUsuario() {
//        return tipoUsuario;
//    }
//
//    public void setTipoUsuario(TipoUsuario tipoUsuario) {
//        this.tipoUsuario = tipoUsuario;
//    }

    public Integer getProgressoTrilha() {
        return progressoTrilha;
    }

    public void setProgressoTrilha(Integer progressoTrilha) {
        this.progressoTrilha = progressoTrilha;
    }

    public Status getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(Status statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
}
