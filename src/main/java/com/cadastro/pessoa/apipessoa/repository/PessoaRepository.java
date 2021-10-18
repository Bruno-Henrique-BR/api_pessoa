package com.cadastro.pessoa.apipessoa.repository;

import com.cadastro.pessoa.apipessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
