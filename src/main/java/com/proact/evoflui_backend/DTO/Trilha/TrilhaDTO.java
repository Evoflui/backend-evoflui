package com.proact.evoflui_backend.DTO.Trilha;

import com.proact.evoflui_backend.DTO.VisualNovel.CenaDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.RelacionamentoUsuarioPersonagemDTO;
import com.proact.evoflui_backend.Enums.StatusTrilha;
import com.proact.evoflui_backend.Model.Novel.Cena;
import com.proact.evoflui_backend.Model.Novel.RelacionamentoUsuarioPersonagem;
import com.proact.evoflui_backend.Model.Trilha.Bloco;
import com.proact.evoflui_backend.Model.Trilha.Trilha;

import java.util.ArrayList;
import java.util.List;

public class TrilhaDTO {

    private Long trilhaId;
    private String tituloTrilha;
    private Long tipoTrilha;
    private StatusTrilha statusTrilha;
    private List<BlocoDTO> blocosTrilha;
    private List<CenaDTO> cenasTrilha;

    public TrilhaDTO() {}

    public TrilhaDTO(Trilha trilha) {
        this.trilhaId = trilha.getTrilhaId();
        this.tituloTrilha = trilha.getTituloTrilha();
        this.tipoTrilha = trilha.getTipoTrilha();
        this.statusTrilha = trilha.getStatusTrilha();
        this.blocosTrilha = converBlocoDTO(trilha.getBlocosTrilha());
        this.cenasTrilha = convertCenaDTO(trilha.getCenasTrilha());
    }

    private List<BlocoDTO> converBlocoDTO(List<Bloco> blocos) {
        List<BlocoDTO> dtoList = new ArrayList<>();
        for (Bloco bloco : blocos) {
            dtoList.add(new BlocoDTO(bloco));
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

    public Long getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(Long trilhaId) {
        this.trilhaId = trilhaId;
    }

    public String getTituloTrilha() {
        return tituloTrilha;
    }

    public void setTituloTrilha(String tituloTrilha) {
        this.tituloTrilha = tituloTrilha;
    }

    public Long getTipoTrilha() {
        return tipoTrilha;
    }

    public void setTipoTrilha(Long tipoTrilha) {
        this.tipoTrilha = tipoTrilha;
    }

    public StatusTrilha getStatusTrilha() {
        return statusTrilha;
    }

    public void setStatusTrilha(StatusTrilha statusTrilha) {
        this.statusTrilha = statusTrilha;
    }

    public List<BlocoDTO> getBlocosTrilha() {
        return blocosTrilha;
    }

    public void setBlocosTrilha(List<BlocoDTO> blocosTrilha) {
        this.blocosTrilha = blocosTrilha;
    }

    public List<CenaDTO> getCenasTrilha() {
        return cenasTrilha;
    }

    public void setCenasTrilha(List<CenaDTO> cenasTrilha) {
        this.cenasTrilha = cenasTrilha;
    }
}
