package com.cadastro.pessoa.apipessoa.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data

@NoArgsConstructor


public class ContatoDTO {

    private String nome;
    @NotBlank
    private String telefone;
    @Email
    private String email;

    private Long idPessoa;
}
