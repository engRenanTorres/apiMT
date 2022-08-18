package com.ols.maricatelecompuro.controller;

import com.ols.maricatelecompuro.controller.dto.DetalhesAlunoDto;
import com.ols.maricatelecompuro.controller.dto.AlunoDto;
import com.ols.maricatelecompuro.controller.form.AlunoForm;
import com.ols.maricatelecompuro.controller.form.UpdateAlunoForm;
import com.ols.maricatelecompuro.model.Aluno;
import com.ols.maricatelecompuro.repository.AlunoRepository;
import com.ols.maricatelecompuro.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/apiUsuario")
@RestController
public class UsuarioController {

  @Autowired
  private AlunoRepository alunoRepository;
  @Autowired
  private EscolaRepository escolaRepository;

  @GetMapping ("/apiTodosUsuarios")
  public List<AlunoDto> getAllUser(){
    List<Aluno> alunos = alunoRepository.findAll();
    return AlunoDto.converter(alunos);
  }

  @GetMapping
  public List<AlunoDto> getUser(String param){
    if(param == null) {
      List<Aluno> alunos = alunoRepository.findAll();
      return AlunoDto.converter(alunos);
    }
    else {
      List<Aluno> alunos = alunoRepository.getUserByAnyParam(param);
      return AlunoDto.converter(alunos);
    }
  }

  @GetMapping ("/apiUsuarioPorNome")
  public List<AlunoDto> getUserByName(String nomeAluno){
    if(nomeAluno == null) {
      List<Aluno> alunos = alunoRepository.findAll();
      return AlunoDto.converter(alunos);
    }
    else {
      List<Aluno> alunos = alunoRepository.findByNomeAluno(nomeAluno);
      return AlunoDto.converter(alunos);
    }
  }
  @GetMapping ("/apiUsuarioPorEscola")
  public List<AlunoDto> getUserBySchool(String nomeEscola){
    if(nomeEscola == null) {
      List<Aluno> alunos = alunoRepository.findAll();
      return AlunoDto.converter(alunos);
    }
    else {
      List<Aluno> alunos = alunoRepository.findByEscola_NomeEscola(nomeEscola);
      return AlunoDto.converter(alunos);
    }
  }

  @PostMapping
  public ResponseEntity<AlunoDto> activeUser(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder uriBuilder) {
    Aluno alunoPost = alunoForm.converter(escolaRepository);
    alunoRepository.save(alunoPost);
    URI uri = uriBuilder.path("/apiUsuario/{id}").buildAndExpand(alunoPost.getId()).toUri();
    return ResponseEntity.created(uri).body(new AlunoDto(alunoPost));
  }

  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity<DetalhesAlunoDto> getDetails(@PathVariable Integer id) {
    Optional<Aluno> alunoOrNull = alunoRepository.findById(id); //devolve null se não existir aluno com este id
    if(alunoOrNull.isPresent()) return ResponseEntity.ok(new DetalhesAlunoDto(alunoOrNull.get()));
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  @Transactional //utilizado sempre em transações que farão escrita no bd
  public ResponseEntity<AlunoDto> updateUser(@PathVariable Integer id, @RequestBody @Valid UpdateAlunoForm alunoForm) {
    Optional<Aluno> alunoOrNull = alunoRepository.findById(id); //devolve null se não existir aluno com este id
    if(alunoOrNull.isPresent()){
      Aluno alunoUpdate = alunoForm.atualizar(id, alunoRepository);
      return ResponseEntity.ok(new AlunoDto(alunoUpdate));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> remove(@PathVariable Integer id) {
    Optional<Aluno> alunoOrNull = alunoRepository.findById(id); //devolve null se não existir aluno com este id
    if(alunoOrNull.isPresent()){
      alunoRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

/*  @GetMapping ("/apiUsuarioDados")
  public List<AlunoDto> getUserData(){
    return AlunoDto.converter(Arrays.asList(alunos));
  }*/

}
