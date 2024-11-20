package com.proact.evoflui_backend.DTO.Trilha;

import com.proact.evoflui_backend.DTO.VisualNovel.CenaDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.EscolhaDTO;
import com.proact.evoflui_backend.Model.Novel.Cena;
import com.proact.evoflui_backend.Model.Novel.Escolha;
import com.proact.evoflui_backend.Model.Trilha.Atividade;
import com.proact.evoflui_backend.Enums.StatusAtividade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AtividadeDTO {
    private Long atividadeId;
    private String tituloAtividade;
    private String enunciadoAtividade;
    private Long respostaAtividade;
    private StatusAtividade statusAtividade;
    private List<EscolhaDTO> opcoesAtividade;
    private List<CenaDTO> cenasAtividade;

    public AtividadeDTO() {}

    public AtividadeDTO(Atividade atividade) {
        this.atividadeId = atividade.getAtividadeId();
        this.tituloAtividade = atividade.getTituloAtividade();
        this.enunciadoAtividade = atividade.getEnunciadoAtividade();
        this.respostaAtividade = atividade.getRespostaAtividade();
        this.statusAtividade = atividade.getStatusAtividade(); 
        this.opcoesAtividade = convertoEscolhaDTO(atividade.getOpcoesAtividade());
        this.cenasAtividade = convertCenaDTO(atividade.getCenasAtividade());
    }

    private List<EscolhaDTO> convertoEscolhaDTO(List<Escolha> escolhas) {
        List<EscolhaDTO> dtoList = new ArrayList<>();
        for (Escolha escolha : escolhas) {
            EscolhaDTO escolhaDTO = new EscolhaDTO(escolha);
            dtoList.add(escolhaDTO);
        }
        return dtoList;
    }

    private List<CenaDTO> convertCenaDTO(List<Cena> cenas) {
        List<CenaDTO> dtoList = new ArrayList<>();
        for (Cena cena : cenas) {
            dtoList.add(new CenaDTO(cena));
        }
        return dtoList;
    }

    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getTituloAtividade() {
        return tituloAtividade;
    }

    public void setTituloAtividade(String tituloAtividade) {
        this.tituloAtividade = tituloAtividade;
    }

    public String getEnunciadoAtividade() {
        return enunciadoAtividade;
    }

    public void setEnunciadoAtividade(String enunciadoAtividade) {
        this.enunciadoAtividade = enunciadoAtividade;
    }

    public Long getRespostaAtividade() {
        return respostaAtividade;
    }

    public void setRespostaAtividade(Long respostaAtividade) {
        this.respostaAtividade = respostaAtividade;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public List<EscolhaDTO> getOpcoesAtividade() {
        return opcoesAtividade;
    }

    public void setOpcoesAtividade(List<EscolhaDTO> opcoesAtividade) {
        this.opcoesAtividade = opcoesAtividade;
    }

    public List<CenaDTO> getCenasAtividade() {
        return cenasAtividade;
    }

    public void setCenasAtividade(List<CenaDTO> cenasAtividade) {
        this.cenasAtividade = cenasAtividade;
    }
}
