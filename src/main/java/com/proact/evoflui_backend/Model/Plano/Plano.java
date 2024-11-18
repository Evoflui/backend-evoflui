package com.proact.evoflui_backend.Model.Plano;

import jakarta.persistence.*;

@Entity
@Table(name = "plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planoId;

    @Column(nullable = false, unique = true, name = "nome_plano")
    private String nomePlano;

    @Column(nullable = false, name = "valor_plano")
    private Double valorPlano;

    @Column(nullable = false, name = "nivel_plano")
    private Integer nivelPlano;


}
