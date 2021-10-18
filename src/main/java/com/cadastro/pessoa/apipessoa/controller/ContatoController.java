package com.cadastro.pessoa.apipessoa.controller;

import com.cadastro.pessoa.apipessoa.controller.dto.ContatoDTO;
import com.cadastro.pessoa.apipessoa.model.Contato;
import com.cadastro.pessoa.apipessoa.model.Pessoa;
import com.cadastro.pessoa.apipessoa.repository.ContatoRepository;
import com.cadastro.pessoa.apipessoa.repository.PessoaRepository;
import com.cadastro.pessoa.apipessoa.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
    @RestController
    @RequestMapping("api/contato")
    public class ContatoController {

        @Autowired
        private ContatoService contatoService;

        private final PessoaRepository pessoaRepository;
        private final ContatoRepository contatoRepository;

        public ContatoController(PessoaRepository pessoaRepository, ContatoRepository contatoRepository) {
            this.pessoaRepository = pessoaRepository;
            this.contatoRepository = contatoRepository;
        }

        @GetMapping("/listar")
        public ResponseEntity<List<Contato>> listarTodos(){
            return ResponseEntity.status(HttpStatus.OK).body(contatoService.listarTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Optional<Contato>> consultarPorId(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.OK).body(contatoService.consultarPorId(id));
        }

        @PostMapping("/salvar")
        public Contato salvar (@RequestBody @Valid ContatoDTO con){
            Long idPessoa = con.getIdPessoa();

            Pessoa pessoa =
                    pessoaRepository.findById(idPessoa).orElseThrow(()->new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,"Pessoa não encontrada."));
            Contato contato = new Contato();
            contato.setNome(con.getNome());
            contato.setTelefone(con.getTelefone());
            contato.setEmail(con.getEmail());
            return contatoRepository.save(contato);


        }

        @PutMapping("/alterar")
        public ResponseEntity<Contato> alterar(@RequestBody Contato contato){
            return ResponseEntity.status(HttpStatus.OK).body(contatoService.alterar(contato));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> excluir(@PathVariable Long id){
            contatoService.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }


    }
