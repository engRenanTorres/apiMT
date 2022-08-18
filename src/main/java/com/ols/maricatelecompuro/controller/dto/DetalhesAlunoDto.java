package com.ols.maricatelecompuro.controller.dto;

import com.ols.maricatelecompuro.model.Aluno;

public class DetalhesAlunoDto {
    private int id;
    private String nomeAluno;
    private String serie;
    private String mensagem;
    private EscolaDto escola;
    private Integer status;

    public DetalhesAlunoDto(Aluno aluno) {
        this.id = aluno.getId();
        this.nomeAluno = aluno.getNomeAluno();
        this.serie = aluno.getSerie();
        this.mensagem = aluno.getMensagem();
        this.escola = new EscolaDto(aluno.getEscola());
        this.status = aluno.getStatus();
    }

    public int getId() {
        return id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getSerie() {
        return serie;
    }

    public String getMensagem() {
        return mensagem;
    }

    public EscolaDto getEscola() {
        return escola;
    }

    public Integer getStatus() {
        return status;
    }
}
