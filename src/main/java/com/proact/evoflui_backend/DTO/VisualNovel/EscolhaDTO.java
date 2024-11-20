package com.proact.evoflui_backend.DTO.VisualNovel;

import com.proact.evoflui_backend.Model.Novel.Escolha;
import com.proact.evoflui_backend.Model.Trilha.Atividade;

public class EscolhaDTO {
    private Long escolhaId;
    private String nomeOpcao;
    private String fotoOpcao;
    private double valorRelacionamento;

    public EscolhaDTO() {}

    public EscolhaDTO(Escolha escolha) {
        this.escolhaId = escolha.getEscolhaId();
        this.nomeOpcao = escolha.getNomeOpcao();
        this.fotoOpcao = escolha.getFotoOpcao();
        this.valorRelacionamento = escolha.getValorRelacionamento();
    }


    public Long getEscolhaId() {
        return escolhaId;
    }

    public void setEscolhaId(Long escolhaId) {
        this.escolhaId = escolhaId;
    }

    public String getNomeOpcao() {
        return nomeOpcao;
    }

    public void setNomeOpcao(String nomeOpcao) {
        this.nomeOpcao = nomeOpcao;
    }

    public String getFotoOpcao() {
        return fotoOpcao;
    }

    public void setFotoOpcao(String fotoOpcao) {
        this.fotoOpcao = fotoOpcao;
    }

    public double getValorRelacionamento() {
        return valorRelacionamento;
    }

    public void setValorRelacionamento(double valorRelacionamento) {
        this.valorRelacionamento = valorRelacionamento;
    }
}
