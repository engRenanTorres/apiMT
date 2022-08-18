package com.ols.maricatelecompuro.controller.form;

import com.ols.maricatelecompuro.model.Aluno;
import com.ols.maricatelecompuro.model.Escola;
import com.ols.maricatelecompuro.repository.AlunoRepository;
import com.ols.maricatelecompuro.repository.EscolaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class UpdateAlunoForm {
    @NotNull @NotNull @Length(max = 100)
    public String nomeAluno;
    @Max(1)
    public Integer status;

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Aluno atualizar(Integer id, AlunoRepository alunoRepository) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.setNomeAluno(this.nomeAluno);
        aluno.setStatus(this.status);
        return aluno;
    }
}
