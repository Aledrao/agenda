package br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades;

import br.com.luizalabs.agenda.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa")
@NoArgsConstructor
public class PessoaEntity {

    @SequenceGenerator(name = "pessoa_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
    @Id
    private Integer id;
    private String nome;
    private String login;
    private String email;

    public PessoaEntity(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.login = pessoa.getLogin();
        this.email = pessoa.getEmail();
    }

    public final Pessoa toPessoa(PessoaEntity pessoaEntity) {
        return new Pessoa(pessoaEntity.id, pessoaEntity.nome, pessoaEntity.login, pessoaEntity.email);
    }

}
