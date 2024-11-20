package com.proact.evoflui_backend.DTO.Usuario;

import com.proact.evoflui_backend.DTO.VisualNovel.RelacionamentoUsuarioPersonagemDTO;
import com.proact.evoflui_backend.Enums.StatusUsuario;
import com.proact.evoflui_backend.Model.Novel.RelacionamentoUsuarioPersonagem;
import com.proact.evoflui_backend.Model.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private Long usuarioId;
    private String nome;
    private String apelido;
    private String email;
    private String senha;
    private Long tipoUsuario;
    private boolean isNovo;
    private Integer progressoTrilha;
    private StatusUsuario statusUsuario;
    private List<RelacionamentoUsuarioPersonagemDTO> relacionamentosUsuario;

    public UsuarioDTO(Usuario usuario) {
        this.usuarioId = usuario.getUsuarioId();
        this.nome = usuario.getNome();
        this.apelido = usuario.getApelido();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.tipoUsuario = usuario.getTipoUsuario();
        this.isNovo = usuario.isNovo();
        this.progressoTrilha = usuario.getProgressoTrilha();
        this.statusUsuario = usuario.getStatusUsuario();
        this.relacionamentosUsuario = convertRelacionamentos(usuario.getRelacionamentosUsuario());
    }

    private List<RelacionamentoUsuarioPersonagemDTO> convertRelacionamentos(List<RelacionamentoUsuarioPersonagem> relacionamentos) {
        List<RelacionamentoUsuarioPersonagemDTO> dtoList = new ArrayList<>();
        for (RelacionamentoUsuarioPersonagem relacionamento : relacionamentos) {
            dtoList.add(new RelacionamentoUsuarioPersonagemDTO(relacionamento));  // Supondo que exista um construtor adequado no DTO
        }
        return dtoList;
    }

    // Getters e Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isNovo() {
        return isNovo;
    }

    public void setNovo(boolean novo) {
        isNovo = novo;
    }

    public Integer getProgressoTrilha() {
        return progressoTrilha;
    }

    public void setProgressoTrilha(Integer progressoTrilha) {
        this.progressoTrilha = progressoTrilha;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public List<RelacionamentoUsuarioPersonagemDTO> getRelacionamentosUsuario() {
        return relacionamentosUsuario;
    }

    public void setRelacionamentosUsuario(List<RelacionamentoUsuarioPersonagemDTO> relacionamentosUsuario) {
        this.relacionamentosUsuario = relacionamentosUsuario;
    }
}
