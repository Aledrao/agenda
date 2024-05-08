package br.com.luizalabs.agenda.dominio.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PessoaDTO {
    private Integer id;
    private String nome;
    private String login;
    private String email;
}
