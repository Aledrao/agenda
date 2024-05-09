package br.com.luizalabs.agenda.infraestrutura.adaptadores.repositories;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.AgendaEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgendaRepository implements AgendaRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public AgendaRepository(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public List<Agenda> buscarPorPessoa(Pessoa pessoa) {
        List<AgendaEntity> agendaEntities = this.springProdutoRepository.findByPessoa(pessoa);
        return agendaEntities.stream().map(AgendaEntity::toAgenda).collect(Collectors.toList());
    }

    @Override
    public Agenda buscarPeloId(Integer id) {
        Optional<AgendaEntity> agendaEntity = this.springProdutoRepository.findById(id);

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
            agendaEntity = this.springProdutoRepository.findById(agenda.getId()).get();
            agendaEntity.atualizar(agenda);
        }
        this.springProdutoRepository.save(agendaEntity);
    }

}
