package com.proact.evoflui_backend.DTO.Trilha;

import com.proact.evoflui_backend.DTO.VisualNovel.CenaDTO;
import com.proact.evoflui_backend.Model.Novel.Cena;
import com.proact.evoflui_backend.Model.Trilha.Atividade;
import com.proact.evoflui_backend.Model.Trilha.Bloco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlocoDTO {
    private Long blocoId;
    private String tituloBloco;
    private Boolean isBloqueado;
    private List<AtividadeDTO> atividadesBloco;
    private List<CenaDTO> cenasBloco;

    public BlocoDTO() {}

    public BlocoDTO(Bloco bloco) {
        this.blocoId = bloco.getBlocoId();
        this.tituloBloco = bloco.getTituloBloco();
        this.isBloqueado = bloco.getBloqueado();
        this.atividadesBloco = convertAtividadeDTO(bloco.getAtividadesBloco());
        this.cenasBloco = convertCenaDTO(bloco.getCenasBloco());
    }

    private List<CenaDTO> convertCenaDTO(List<Cena> cenas) {
        List<CenaDTO> dtoList = new ArrayList<>();
        for (Cena cena : cenas) {
            dtoList.add(new CenaDTO(cena));
        }
        return dtoList;
    }

    private List<AtividadeDTO> convertAtividadeDTO(List<Atividade> atividades) {
        List<AtividadeDTO> dtoList = new ArrayList<>();
        for (Atividade atividade : atividades) {
            dtoList.add(new AtividadeDTO(atividade));
        }
        return dtoList;
    }

    public Long getBlocoId() {
        return blocoId;
    }

    public void setBlocoId(Long blocoId) {
        this.blocoId = blocoId;
    }

    public String getTituloBloco() {
        return tituloBloco;
    }

    public void setTituloBloco(String tituloBloco) {
        this.tituloBloco = tituloBloco;
    }

    public Boolean getIsBloqueado() {
        return isBloqueado;
    }

    public void setIsBloqueado(Boolean isBloqueado) {
        this.isBloqueado = isBloqueado;
    }

    public List<AtividadeDTO> getAtividadesBlocoIds() {
        return atividadesBloco;
    }

    public void setAtividadesBloco(List<AtividadeDTO> atividadesBloco) {
        this.atividadesBloco = atividadesBloco;
    }

    public List<CenaDTO> getCenasBloco() {
        return cenasBloco;
    }

    public void setCenasBloco(List<CenaDTO> cenasBloco) {
        this.cenasBloco = cenasBloco;
    }
}
