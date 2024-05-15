package br.com.luizalabs.agenda.dominio.adaptadores.services;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import br.com.luizalabs.agenda.dominio.dtos.MensagemDTO;
import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;
import br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgendaServiceImpTest {

    @InjectMocks
    private AgendaServiceImp agendaServiceImp;

    @Mock
    private AgendaRepositoryPort agendaRepositoryPort;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(AgendaServiceImpTest.class);
    }

    @Test
    public void buscarPeloIdTest_Success() {
        Agenda agenda = new Agenda(1L, null, null, "Teste",
                new Pessoa(1, null, null, null), new Pessoa(2, null, null, null));
        Integer idAgenda = 1;

        when(agendaRepositoryPort.buscarPeloId(idAgenda)).thenReturn(agenda);

        AgendaDTO response = agendaServiceImp.buscarPeloId(idAgenda);

        assertNotNull(response);
        assertEquals(idAgenda.longValue(), response.getId());
    }

    @Test
    public void criarAgendaTest_Success() {
        AgendaServiceImp agendaService = mock(AgendaServiceImp.class);
        AgendaDTO agendaDTO = new AgendaDTO(1L, null, null, "Teste",
                new PessoaDTO(1, null, null, null), new PessoaDTO(2, null, null, null));

        doNothing().when(agendaService).criarAgenda(agendaDTO);
        agendaService.criarAgenda(agendaDTO);

        verify(agendaService).criarAgenda(agendaDTO);
    }

    @Test
    public void buscarAgendaPorPessoaTest_Success() {
        Pessoa pessoa = new Pessoa(1, "Testando", "teste", "teste@teste.com.br");
        Agenda agenda = new Agenda(1L, null, null, "Testando",
                pessoa, new Pessoa(2, null, null, null));
        PessoaDTO pessoaDTO = new PessoaDTO(1, "Testando", "teste", "teste@teste.com.br");
        List<Agenda> listAgendas = new ArrayList<>();
        listAgendas.add(agenda);

        when(this.agendaRepositoryPort.buscarPorDestinatario(pessoa)).thenReturn(listAgendas);

        List<AgendaDTO> response = this.agendaServiceImp.buscarAgendaPorPessoa(pessoaDTO);

        assertNotNull(response);
        assertEquals(pessoaDTO.getId(), response.get(0).getDestinatario().getId());
    }

    @Test
    public void atualizarAgendaTest_Success() throws NotFoundException {
        AgendaServiceImp agendaService = mock(AgendaServiceImp.class);
        Integer idAgenda = 1;
        MensagemDTO mensagemDTO = new MensagemDTO();

        doNothing().when(agendaService).atualizarAgenda(idAgenda, mensagemDTO);
        agendaService.atualizarAgenda(idAgenda, mensagemDTO);

        verify(agendaService).atualizarAgenda(idAgenda, mensagemDTO);
    }

    @Test
    public void excluirAgendaTest_Success() throws NotFoundException {
        AgendaServiceImp agendaService = mock(AgendaServiceImp.class);
        Integer idAgenda = 1;
        MensagemDTO mensagemDTO = new MensagemDTO();

        doNothing().when(agendaService).excluirAgenda(idAgenda);
        agendaService.excluirAgenda(idAgenda);

        verify(agendaService).excluirAgenda(idAgenda);
    }

}