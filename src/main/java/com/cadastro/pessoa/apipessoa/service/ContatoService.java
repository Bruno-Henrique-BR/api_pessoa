package com.cadastro.pessoa.apipessoa.service;

import com.cadastro.pessoa.apipessoa.model.Contato;
import com.cadastro.pessoa.apipessoa.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface ContatoService {
    Contato salvar(Contato contato);
    List<Contato> listarTodos();
    Optional<Contato> consultarPorId(Long id);

    Contato alterar(Contato contato);

    void excluir(Long id);
}
