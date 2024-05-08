package br.com.luizalabs.agenda.dominio.adaptadores.services;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import br.com.luizalabs.agenda.dominio.dtos.MensagemDTO;
import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;
import br.com.luizalabs.agenda.dominio.portas.interfaces.AgendaServicePort;
import br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AgendaServiceImp implements AgendaServicePort {

    private final AgendaRepositoryPort agendaRepository;

    public AgendaServiceImp(AgendaRepositoryPort agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public List<AgendaDTO> buscarAgendaPorPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        List<Agenda> agendas = this.agendaRepository.buscarPorPessoa(pessoa);
        List<AgendaDTO> agendaDTOS = agendas.stream().map(Agenda::agendaDTO).collect(Collectors.toList());
        return agendaDTOS;
    }

    @Override
    public void criarAgenda(AgendaDTO agendaDTO) {
        Agenda agenda = new Agenda(agendaDTO);
        this.agendaRepository.salvar(agenda);
    }

    @Override
    public void atualizarAgenda(Integer id, MensagemDTO mensagemDTO) throws NotFoundException {
        Agenda agenda = this.agendaRepository.buscarPeloId(id);

        if(Objects.isNull(agenda))
            throw new NotFoundException("Agenda não encontrada");


    }
}
