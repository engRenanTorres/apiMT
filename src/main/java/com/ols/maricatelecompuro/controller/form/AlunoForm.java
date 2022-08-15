package com.ols.maricatelecompuro.controller.form;

import com.ols.maricatelecompuro.model.Aluno;
import com.ols.maricatelecompuro.model.Escola;
import com.ols.maricatelecompuro.repository.EscolaRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlunoForm {
  @NotNull @NotEmpty @Length(max = 100)
  private String nomeAluno;
  @Max(1)
  private Integer status;

  private String serie;

  private String mensagem;
  @ManyToOne
  @Nullable
  private String nomeEscola;

  public AlunoForm() {
  }

  public Aluno converter(EscolaRepository escolaRepository) {
    Escola escola = escolaRepository.findByNomeEscola(nomeEscola);
    return new Aluno(nomeAluno,status,serie,mensagem,escola);
  }

  public String getNomeAluno() {
    return nomeAluno;
  }

  public void setNomeAluno(String nomeAluno) {
    this.nomeAluno = nomeAluno;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Nullable
  public String getSerie() {
    return serie;
  }

  public void setSerie(@Nullable String serie) {
    this.serie = serie;
  }

  @Nullable
  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(@Nullable String mensagem) {
    this.mensagem = mensagem;
  }

  @Nullable
  public String getNomeEscola() {
    return nomeEscola;
  }

  public void setNomeEscola(@Nullable String nomeEscola) {
    this.nomeEscola = nomeEscola;
  }
}
