package com.ols.maricatelecompuro.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Aluno {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nomeAluno;
  @Nullable
  private String serie;
  @Nullable
  private String mensagem;
  @ManyToOne @Nullable
  private Escola escola;
  @Nullable
  private int status;
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
