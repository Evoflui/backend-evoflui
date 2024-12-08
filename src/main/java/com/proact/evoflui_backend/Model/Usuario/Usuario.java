package com.proact.evoflui_backend.Model.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proact.evoflui_backend.Model.Novel.RelacionamentoUsuarioPersonagem;
import com.proact.evoflui_backend.Enums.StatusUsuario;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(nullable = false)
    private String nome;

    private String apelido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(name = "tipo_id")
    private Long tipoUsuario;

    @Column(name = "is_novo")
    private boolean isNovo;

    @Column(name = "progresso_trilha", columnDefinition = "INT DEFAULT 0")
    private Integer progressoTrilha = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_usuario", nullable = false)
    private StatusUsuario statusUsuario;

    @JsonManagedReference
    @OneToMany(mappedBy = "forUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RelacionamentoUsuarioPersonagem> relacionamentosUsuario;

    public Usuario() {}

    public Usuario(String nome, String email, String apelido,  String senha, Long tipoUsuario, Integer progressoTrilha, List<RelacionamentoUsuarioPersonagem> relacionamentosUsuario, StatusUsuario statusUsuario) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.isNovo = true;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.progressoTrilha = progressoTrilha;
        this.statusUsuario = statusUsuario;
        this.relacionamentosUsuario = relacionamentosUsuario;
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

    public boolean isNovo() {return isNovo;}

    public void setNovo(boolean novo) {isNovo = novo;}

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public List<RelacionamentoUsuarioPersonagem> getRelacionamentosUsuario() {return relacionamentosUsuario;}

    public void setRelacionamentosUsuario(List<RelacionamentoUsuarioPersonagem> relacionamentosUsuario) {this.relacionamentosUsuario = relacionamentosUsuario;}

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

    public Long getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
}
