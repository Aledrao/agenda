package br.com.luizalabs.agenda.infraestrutura.adaptadores.repositories;

import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.AgendaEntity;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringAgendaRepository extends JpaRepository<AgendaEntity, Long> {

    Optional<AgendaEntity> findById(Integer id);

    List<AgendaEntity> findByDestinatario(PessoaEntity pessoaEntity);

    void deleteById(Integer id);

}
