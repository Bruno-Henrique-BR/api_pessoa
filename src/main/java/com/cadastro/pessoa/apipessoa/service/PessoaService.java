package com.cadastro.pessoa.apipessoa.service;

import com.cadastro.pessoa.apipessoa.model.Contato;
import com.cadastro.pessoa.apipessoa.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa);

    List<Pessoa> listarTodos();

    Optional<Pessoa> consultarPorId(Long id);

    Pessoa alterar(Pessoa pessoa);

    void excluir(Long id);


}
