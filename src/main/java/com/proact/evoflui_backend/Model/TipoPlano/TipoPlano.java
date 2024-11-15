package com.proact.evoflui_backend.Model.TipoPlano;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_plano")
public class TipoPlano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipo_id;

    @Column(nullable = false, unique = true)
    private String nome_tipo;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer nivel;
}
