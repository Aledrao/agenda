package br.com.luizalabs.agenda.aplicacao.adaptadores.controllers;

import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import br.com.luizalabs.agenda.dominio.dtos.MensagemDTO;
import br.com.luizalabs.agenda.dominio.dtos.PessoaDTO;
import br.com.luizalabs.agenda.dominio.portas.interfaces.AgendaServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendas")
public class AgendaController {

    private final AgendaServicePort agendaServicePort;

    public AgendaController(AgendaServicePort agendaServicePort) {
        this.agendaServicePort = agendaServicePort;
    }

    @PostMapping
    void criarAgendas(@RequestBody AgendaDTO agendaDTO) {
        agendaServicePort.criarAgenda(agendaDTO);
    }

    @GetMapping
    List<AgendaDTO> getAgendasPorDestinatario(@RequestBody PessoaDTO pessoaDTO) {
        return agendaServicePort.buscarAgendaPorPessoa(pessoaDTO);
    }

    @GetMapping("/{id}")
    AgendaDTO getAgendaPorId(@PathVariable Integer id) {
        return agendaServicePort.buscarPeloId(id);
    }

    @PutMapping(value = "/{id}")
    void atualiarAgenda(@PathVariable Integer id, @RequestBody MensagemDTO mensagemDTO) throws NotFoundException {
        agendaServicePort.atualizarAgenda(id, mensagemDTO);
    }

    @DeleteMapping(value = "/{id}")
    void deletarAgenda(@PathVariable Integer id) throws NotFoundException {
        agendaServicePort.excluirAgenda(id);
    }

}
