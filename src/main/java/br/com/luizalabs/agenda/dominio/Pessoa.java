package br.com.luizalabs.agenda.dominio;

import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Pessoa {

    private Integer id;
    private String nome;
    private String login;
    private String email;

    public Pessoa(PessoaDTO pessoaDTO) {
        this.id = pessoaDTO.getId();
        this.nome = pessoaDTO.getNome();
        this.login = pessoaDTO.getLogin();
        this.email = pessoaDTO.getEmail();
    }
    public PessoaDTO pessoaDTO() {
        return new PessoaDTO(this.id, this.nome, this.login, this.email);
    }

}
