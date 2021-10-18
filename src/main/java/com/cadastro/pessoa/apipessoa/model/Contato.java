package com.cadastro.pessoa.apipessoa.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

}
