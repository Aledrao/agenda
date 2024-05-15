package br.com.luizalabs.agenda.dominio.portas.repositories;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;

import java.util.List;

public interface AgendaRepositoryPort {

    List<Agenda> buscarPorDestinatario(Pessoa destinatario);

    Agenda buscarPeloId(Integer id);

    void salvar(Agenda agenda);

    void excluir(Integer id);

}
