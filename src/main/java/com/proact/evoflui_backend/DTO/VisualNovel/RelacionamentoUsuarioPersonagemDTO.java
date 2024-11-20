package com.proact.evoflui_backend.DTO.VisualNovel;

import com.proact.evoflui_backend.Controller.PersonagemController;
import com.proact.evoflui_backend.Model.Novel.Personagem;
import com.proact.evoflui_backend.Model.Novel.RelacionamentoUsuarioPersonagem;

public class RelacionamentoUsuarioPersonagemDTO {
    private Long relacionamentoId;
    private double relacionamentoValor;
    private Long forPersonagem;

    public RelacionamentoUsuarioPersonagemDTO() {
    }

    public RelacionamentoUsuarioPersonagemDTO(RelacionamentoUsuarioPersonagem relacionamentoUsuarioPersonagem) {
        this.relacionamentoId = relacionamentoUsuarioPersonagem.getRelacionamentoId();
        this.relacionamentoValor = relacionamentoUsuarioPersonagem.getRelacionamentoValor();
        this.forPersonagem = relacionamentoUsuarioPersonagem.getForPersonagem();
    }

    public Long getRelacionamentoId() {
        return relacionamentoId;
    }

    public void setRelacionamentoId(Long relacionamentoId) {
        this.relacionamentoId = relacionamentoId;
    }

    public double getRelacionamentoValor() {
        return relacionamentoValor;
    }

    public void setRelacionamentoValor(double relacionamentoValor) {
        this.relacionamentoValor = relacionamentoValor;
    }

    public Long getForPersonagem() {
        return forPersonagem;
    }

    public void setForPersonagem(Long forPersonagem) {
        this.forPersonagem = forPersonagem;
    }
}
