package com.ols.maricatelecompuro.controller.form;

import com.ols.maricatelecompuro.model.Aluno;
import com.ols.maricatelecompuro.model.Escola;
import com.ols.maricatelecompuro.repository.AlunoRepository;
import com.ols.maricatelecompuro.repository.EscolaRepository;
import org.springframework.lang.Nullable;

import javax.persistence.ManyToOne;

public class AlunoForm {
  private String nome;
  private int status;

  @Nullable
  private String serie;
  @Nullable
  private String mensagem;
  @ManyToOne
  @Nullable
  private String nomeEscola;

  public AlunoForm() {
  }

  public Aluno converter(EscolaRepository escolaRepository) {
    Escola escola = escolaRepository.findByNome(nomeEscola);
    return new Aluno(nome,status,serie,mensagem,escola);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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
