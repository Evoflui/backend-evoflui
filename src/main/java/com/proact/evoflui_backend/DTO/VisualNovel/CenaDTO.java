package com.proact.evoflui_backend.DTO.VisualNovel;

import com.proact.evoflui_backend.DTO.VisualNovel.EscolhaDTO;
import com.proact.evoflui_backend.Model.Novel.Cena;
import com.proact.evoflui_backend.Model.Novel.Escolha;

import java.util.ArrayList;
import java.util.List;

public class CenaDTO {
    private Long cenaId;
    private String fraseCena;
    private Long personagemCena;
    private List<EscolhaDTO> escolhas;

    public CenaDTO() {}

    public CenaDTO(Cena cena) {
        this.cenaId = cena.getCenaId();
        this.fraseCena = cena.getFraseCena();
        this.personagemCena = cena.getPersonagemCena();
        this.escolhas = convertoEscolhaDTO(cena.getEscolhasCena());
    }

    private List<EscolhaDTO> convertoEscolhaDTO(List<Escolha> escolhas) {
        List<EscolhaDTO> dtoList = new ArrayList<>();
        for (Escolha escolha : escolhas) {
            EscolhaDTO escolhaDTO = new EscolhaDTO(escolha);
            dtoList.add(escolhaDTO);
        }
        return dtoList;
    }

    // Getters and Setters

    public Long getCenaId() {
        return cenaId;
    }

    public void setCenaId(Long cenaId) {
        this.cenaId = cenaId;
    }

    public String getFraseCena() {
        return fraseCena;
    }

    public void setFraseCena(String fraseCena) {
        this.fraseCena = fraseCena;
    }

    public Long getPersonagemCena() {
        return personagemCena;
    }

    public void setPersonagemCena(Long personagemCena) {
        this.personagemCena = personagemCena;
    }

    public List<EscolhaDTO> getEscolhas() {
        return escolhas;
    }

    public void setEscolhas(List<EscolhaDTO> escolhas) {
        this.escolhas = escolhas;
    }
}
