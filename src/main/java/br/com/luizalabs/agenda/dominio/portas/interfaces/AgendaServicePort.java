package br.com.luizalabs.agenda.dominio.portas.interfaces;

import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import br.com.luizalabs.agenda.dominio.dtos.MensagemDTO;
import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgendaServicePort {

    List<AgendaDTO> buscarAgendaPorPessoa(PessoaDTO pessoaDTO);

    AgendaDTO buscarPeloId(Integer id);

    void criarAgenda(AgendaDTO agendaDTO);

    void atualizarAgenda(Integer id, MensagemDTO mensagemDTO) throws NotFoundException;

    void excluirAgenda(Integer id) throws NotFoundException;

}
