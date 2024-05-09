package br.com.luizalabs.agenda.infraestrutura.adaptadores.repositories;

import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringProdutoRepository extends JpaRepository<AgendaEntity, Long> {

    Optional<AgendaEntity> findById(Integer id);

    List<AgendaEntity> findByPessoa(Pessoa pessoa);

    void deleteById(Integer id);

}
