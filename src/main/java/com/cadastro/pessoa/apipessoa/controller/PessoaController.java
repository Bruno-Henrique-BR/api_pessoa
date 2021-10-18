package com.cadastro.pessoa.apipessoa.controller;

import com.cadastro.pessoa.apipessoa.model.Contato;
import com.cadastro.pessoa.apipessoa.model.Pessoa;
import com.cadastro.pessoa.apipessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> consultarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.consultarPorId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoa));
    }

    @PutMapping("/alterar")
    public ResponseEntity<Pessoa> alterar(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.alterar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}