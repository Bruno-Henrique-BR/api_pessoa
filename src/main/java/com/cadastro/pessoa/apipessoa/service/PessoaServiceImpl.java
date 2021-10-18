package com.cadastro.pessoa.apipessoa.service;

import com.cadastro.pessoa.apipessoa.model.Pessoa;
import com.cadastro.pessoa.apipessoa.model.Contato;
import com.cadastro.pessoa.apipessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }


    @Override
    public Optional<Pessoa> consultarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa alterar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

}
