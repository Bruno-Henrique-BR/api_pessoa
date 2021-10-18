package com.cadastro.pessoa.apipessoa.repository;

import com.cadastro.pessoa.apipessoa.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
