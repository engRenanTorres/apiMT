package com.ols.maricatelecompuro.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Aluno {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nomeAluno;

  private String serie;

  private String mensagem;
  @ManyToOne
  private Escola escola;
  private Integer status;
/*
  @Nullable
  private int matricula_aluno;
  @Nullable
  private String primeiro_nome;
  @Nullable
  private String turma;
  @Nullable
  private String filiacao_aluno_1;
  @Nullable
  private String responsavel;
  @Nullable
  private String mensagem_instante;
  @Nullable
  private String midia;
  @Nullable
  private String pdf;
  @Nullable
  private String foto;
  @Nullable
  private int tempo_exibicao;
  @Nullable
  private String id_aparelho;*/


  public Aluno() {
  }
  public Aluno(String nomeAluno, int status,String serie,String mensagem, Escola escola) {
    this.nomeAluno = nomeAluno;
    this.status = status;
    this.mensagem = mensagem;
    this.serie =serie;
    this.escola = escola;
  }

  public void setNomeAluno(String nomeAluno) {
    this.nomeAluno = nomeAluno;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public void setEscola(Escola escola) {
    this.escola = escola;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Nullable
  public Escola getEscola() {
    return escola;
  }

  public int getStatus() {
    return status;
  }

  public int getId() {
    return id;
  }

  @Nullable
  public String getSerie() {
    return serie;
  }

  public String getNomeAluno() {
    return nomeAluno;
  }

  @Nullable
  public String getMensagem() {
    return mensagem;
  }
}
