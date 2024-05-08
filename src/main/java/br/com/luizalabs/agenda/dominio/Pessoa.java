package br.com.luizalabs.agenda.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Pessoa {

    private Integer id;
    private String nome;
    private String login;
    private String email;
}
