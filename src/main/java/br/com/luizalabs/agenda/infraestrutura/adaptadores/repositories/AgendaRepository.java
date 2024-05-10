package br.com.luizalabs.agenda.infraestrutura.adaptadores.repositories;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.AgendaEntity;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.PessoaEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AgendaRepository implements AgendaRepositoryPort {

    private final SpringAgendaRepository springAgendaRepository;

    public AgendaRepository(SpringAgendaRepository springAgendaRepository) {
        this.springAgendaRepository = springAgendaRepository;
    }

    @Override
    public List<Agenda> buscarPorDestinatario(Pessoa destinatario) {
        PessoaEntity pessoaEntity = new PessoaEntity(destinatario);
        List<AgendaEntity> agendaEntities = this.springAgendaRepository.findByDestinatario(pessoaEntity);
        return agendaEntities.stream().map(AgendaEntity::toAgenda).collect(Collectors.toList());
    }

    @Override
    public Agenda buscarPeloId(Integer id) {
        Optional<AgendaEntity> agendaEntity = this.springAgendaRepository.findById(id);

        if(agendaEntity.isPresent())
            return agendaEntity.get().toAgenda();

        throw new RuntimeException("Agenda não existe");
    }

    @Override
    public void salvar(Agenda agenda) {
        AgendaEntity agendaEntity;
        if(Objects.isNull(agenda.getId()))
            agendaEntity = new AgendaEntity(agenda);
        else {
            agendaEntity = this.springAgendaRepository.findById(agenda.getId()).get();
            agendaEntity.atualizar(agenda);
        }
        this.springAgendaRepository.save(agendaEntity);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        Optional<AgendaEntity> agendaEntity = this.springAgendaRepository.findById(id);

        if(agendaEntity.isPresent())
            this.springAgendaRepository.deleteById(id);
        else
            throw new RuntimeException("Agenda não existe");
    }

}
