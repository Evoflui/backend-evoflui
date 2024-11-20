package com.proact.evoflui_backend.DTO.VisualNovel;

import com.proact.evoflui_backend.Model.Novel.Personagem;

public class PersonagemDTO {
    private Long personagemId;
    private String fotoPersonagem;
    private String nomePersonagem;

    public PersonagemDTO() {}

    public PersonagemDTO(Personagem personagem) {
        this.personagemId = personagem.getPersonagemId();
        this.fotoPersonagem = personagem.getFotoPersonagem();
        this.nomePersonagem = personagem.getNomePersonagem();
    }

    public Long getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(Long personagemId) {
        this.personagemId = personagemId;
    }

    public String getFotoPersonagem() {
        return fotoPersonagem;
    }

    public void setFotoPersonagem(String fotoPersonagem) {
        this.fotoPersonagem = fotoPersonagem;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
}
