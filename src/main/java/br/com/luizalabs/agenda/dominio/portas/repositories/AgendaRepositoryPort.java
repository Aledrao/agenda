package br.com.luizalabs.agenda.dominio.portas.repositories;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;

import java.util.List;

public interface AgendaRepositoryPort {

    List<Agenda> buscarPorPessoa(Pessoa pessoa);

    Agenda buscarPeloId(Integer id);

    void salvar(Agenda agenda);

    void excluir(Integer id);
}
