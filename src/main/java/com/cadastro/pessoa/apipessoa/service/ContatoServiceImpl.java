package com.cadastro.pessoa.apipessoa.service;

import com.cadastro.pessoa.apipessoa.model.Contato;
import com.cadastro.pessoa.apipessoa.model.Pessoa;
import com.cadastro.pessoa.apipessoa.repository.ContatoRepository;
import com.cadastro.pessoa.apipessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ContatoService{

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }
    @Override
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }
    @Override
    public Optional<Contato> consultarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public Contato alterar(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public void excluir(Long id) {
        contatoRepository.deleteById(id);
    }

}
