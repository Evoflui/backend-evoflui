package com.proact.evoflui_backend.Model.Novel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "relacionamento_personagem")
public class RelacionamentoUsuarioPersonagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relacionamento_id")
    private Long relacionamentoId;

    @Column(name = "relacionamento_valor")
    private double relacionamentoValor;

    @Column(name = "personagem_id")
    private Long forPersonagem;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario forUsuario;

    public RelacionamentoUsuarioPersonagem() {}

    public RelacionamentoUsuarioPersonagem(Long forPersonagem, Usuario forUsuario) {
        this.forPersonagem = forPersonagem;
        this.forUsuario = forUsuario;
        this.relacionamentoValor = 0.0;
    }

    public Long getRelacionamentoId() {return relacionamentoId;}

    public double getRelacionamentoValor() {return relacionamentoValor;}

    public void setRelacionamentoValor(double relacionamentoValor) {this.relacionamentoValor = relacionamentoValor;}

    public Long getForPersonagem() {return forPersonagem;}

    public void setForPersonagem(Long forPersonagem) {this.forPersonagem = forPersonagem;}

    public Usuario getForUsuario() {return forUsuario;}

    public void setForUsuario(Usuario forUsuario) {this.forUsuario = forUsuario;}
}
