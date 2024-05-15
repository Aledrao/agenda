package br.com.luizalabs.agenda.infraestrutura.adaptadores.repositories;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.AgendaEntity;
import br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades.PessoaEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgendaRepositoryTest {

    @InjectMocks
    private AgendaRepository agendaRepository;

    @Mock
    private SpringAgendaRepository springAgendaRepository;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(AgendaRepositoryTest.class);
    }

    @Test
    public void buscarPorDestinatarioTest_Success() {
        Pessoa pessoa = new Pessoa(1, "Testando", "testando", "teste@teste.com");
        Agenda agenda = new Agenda(1L, null, null, "Teste", pessoa, pessoa);
        AgendaEntity agendaEntity = new AgendaEntity(agenda);
        List<AgendaEntity> agendaEntityList = Arrays.asList(agendaEntity);

        when(springAgendaRepository.findByDestinatario(any(PessoaEntity.class))).thenReturn(agendaEntityList);
        List<Agenda> response = agendaRepository.buscarPorDestinatario(pessoa);

        assertNotNull(response);
    }

    @Test
    public void buscarPeloIdTest_Success() {
        Integer agendaId = 1;
        Pessoa pessoa = new Pessoa(1, "Testando", "testando", "teste@teste.com");
        Agenda agenda = new Agenda(1L, null, null, "Teste", pessoa, pessoa);
        AgendaEntity agendaEntity = new AgendaEntity(agenda);
        Optional<AgendaEntity> optionalAgendaEntity = Optional.of(agendaEntity);

        when(springAgendaRepository.findById(1)).thenReturn(optionalAgendaEntity);

        Agenda response = agendaRepository.buscarPeloId(agendaId);

        assertNotNull(response);
        assertEquals(agendaId.longValue(), response.getId());
    }

    @Test
    public void salvar_persistir_Sucess() {
        AgendaRepository agendaRep = mock(AgendaRepository.class);
        Pessoa pessoa = new Pessoa(1, "Testando", "testando", "teste@teste.com");
        Agenda agenda = new Agenda(1L, null, null, "Teste", pessoa, pessoa);

        doNothing().when(agendaRep).salvar(agenda);
        agendaRep.salvar(agenda);

        verify(agendaRep).salvar(agenda);
    }

    @Test
    public void salvar_atualizar_Sucess() {
        AgendaRepository agendaRep = mock(AgendaRepository.class);
        Pessoa pessoa = new Pessoa(1, "Testando", "testando", "teste@teste.com");
        Agenda agenda = new Agenda(null, null, null, "Teste", pessoa, pessoa);

        doNothing().when(agendaRep).salvar(agenda);
        agendaRep.salvar(agenda);

        verify(agendaRep).salvar(agenda);
    }

    @Test
    public void excluir_Sucess() {
        Integer agendaId = 1;
        AgendaRepository agendaRep = mock(AgendaRepository.class);

        doNothing().when(agendaRep).excluir(agendaId);
        agendaRep.excluir(agendaId);

        verify(agendaRep).excluir(agendaId);
    }

}