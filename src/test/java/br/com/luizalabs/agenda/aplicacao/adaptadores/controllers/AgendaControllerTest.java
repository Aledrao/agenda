package br.com.luizalabs.agenda.aplicacao.adaptadores.controllers;

import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import br.com.luizalabs.agenda.dominio.dtos.MensagemDTO;
import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;
import br.com.luizalabs.agenda.dominio.portas.interfaces.AgendaServicePort;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgendaControllerTest {

    @InjectMocks
    private AgendaController agendaController;

    @Mock
    private AgendaServicePort agendaServicePort;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(AgendaControllerTest.class);
    }

    @Test
    public void criarAgendasTest_Success() {
        AgendaController agendaControl = mock(AgendaController.class);
        AgendaDTO agendaDTO = new AgendaDTO(1L, null, null, "Teste",
                new PessoaDTO(1, null, null, null), new PessoaDTO(2, null, null, null));

        doNothing().when(agendaControl).criarAgendas(agendaDTO);
        agendaControl.criarAgendas(agendaDTO);

        verify(agendaControl).criarAgendas(agendaDTO);
    }

    @Test
    public void getAgendaPorDestinatarioTest_Success() {
        AgendaDTO agendaDTO = new AgendaDTO(1L, null, null, "Testando",
                new PessoaDTO(1, null, null, null), new PessoaDTO(2, null, null, null));
        PessoaDTO pessoaDTO = new PessoaDTO(1, null, null, null);
        List<AgendaDTO> listAgendasDTO = new ArrayList<>();
        listAgendasDTO.add(agendaDTO);

        Mockito.when(agendaServicePort.buscarAgendaPorPessoa(pessoaDTO)).thenReturn(listAgendasDTO);

        List<AgendaDTO> result = agendaController.getAgendasPorDestinatario(pessoaDTO);

        assertNotNull(result);
        assertEquals(agendaDTO.getId(), result.get(0).getId());
    }

    @Test
    public void getAgendaPorIdTest_Success() {
        AgendaDTO agendaDTO = new AgendaDTO(1L, null, null, "Testando",
                new PessoaDTO(1, null, null, null), new PessoaDTO(2, null, null, null));
        PessoaDTO pessoaDTO = new PessoaDTO(1, null, null, null);
        List<AgendaDTO> listAgendasDTO = Arrays.asList(agendaDTO);

        Mockito.when(agendaServicePort.buscarPeloId(1)).thenReturn(agendaDTO);

        AgendaDTO result = agendaController.getAgendaPorId(1);

        assertNotNull(result);
        assertEquals(agendaDTO.getId(), result.getId());
    }

    @Test
    public void atualizarAgendaTest_Success() throws NotFoundException {
        AgendaController agendaControl = mock(AgendaController.class);
        Integer agendaId = 1;
        MensagemDTO mensagemDTO = new MensagemDTO();

        doNothing().when(agendaControl).atualizarAgenda(agendaId, mensagemDTO);
        agendaControl.atualizarAgenda(agendaId, mensagemDTO);

        verify(agendaControl).atualizarAgenda(agendaId, mensagemDTO);
    }

    @Test
    public void deletarAgendaTest_Success() throws NotFoundException {
        AgendaController agendaControl = mock(AgendaController.class);
        Integer agendaId = 1;

        doNothing().when(agendaControl).deletarAgenda(agendaId);
        agendaControl.deletarAgenda(agendaId);

        verify(agendaControl).deletarAgenda(agendaId);
    }

}