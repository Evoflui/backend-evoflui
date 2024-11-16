package com.proact.evoflui_backend.Model.Usuario;

import com.proact.evoflui_backend.Enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoUsuario tipoUsuario;

    @Column(name = "progresso_trilha", columnDefinition = "INT DEFAULT 0")
    private Integer progressoTrilha = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_usuario")
    private Status statusUsuario;

    public Usuario() {}

    public Usuario(Long usuarioId, String nome, String email, String senha, TipoUsuario tipoUsuario, Integer progressoTrilha, Status statusUsuario) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getProgressoTrilha() {
        return progressoTrilha;
    }

    public void setProgressoTrilha(Integer progressoTrilha) {
        this.progressoTrilha = progressoTrilha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Status getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(Status statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
}
