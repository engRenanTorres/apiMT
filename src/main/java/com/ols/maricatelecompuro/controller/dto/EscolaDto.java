package com.ols.maricatelecompuro.controller.dto;


import com.ols.maricatelecompuro.model.Escola;

public class EscolaDto {
    private Integer id;
    private String nomeEscola;

    public EscolaDto (Escola escola){
        this.id = escola.getId();
        this.nomeEscola = escola.getNomeEscola();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }
}
