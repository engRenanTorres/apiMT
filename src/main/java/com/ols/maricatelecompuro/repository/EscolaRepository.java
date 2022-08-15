package com.ols.maricatelecompuro.repository;

import com.ols.maricatelecompuro.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {
  Escola findByNome(String nomeEscola);
}
