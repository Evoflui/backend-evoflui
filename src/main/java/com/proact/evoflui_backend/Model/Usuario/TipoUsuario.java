package com.proact.evoflui_backend.Model.Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipo_id;

    @Column(nullable = false, unique = true)
    private String nome_tipo;

    public TipoUsuario() {
    }

    public TipoUsuario(Long tipo_id, String nome_tipo) {
        this.tipo_id = tipo_id;
        this.nome_tipo = nome_tipo;
    }

    public Long gettipoId() {
        return tipo_id;
    }

    public void settipoId(Long tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getNome_tipo() {
        return nome_tipo;
    }

    public void setNome_tipo(String nome_tipo) {
        this.nome_tipo = nome_tipo;
    }
}
