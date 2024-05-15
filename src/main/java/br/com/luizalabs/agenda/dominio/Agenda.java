package br.com.luizalabs.agenda.dominio;

import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Agenda {

    private Long id;
    private LocalDateTime envio;
    private LocalDateTime ultima_atualizacao;
    private String mensagem;
    private Pessoa destinatario;
    private Pessoa remetente;

    public Agenda(AgendaDTO agendaDTO) {
        this.id = agendaDTO.getId();
        this.envio = agendaDTO.getEnvio();
        this.ultima_atualizacao = agendaDTO.getUltima_atualizacao();
        this.mensagem = agendaDTO.getMensagem();
        this.destinatario = new Pessoa(agendaDTO.getDestinatario().getId(), agendaDTO.getDestinatario().getNome(), agendaDTO.getDestinatario().getLogin(), agendaDTO.getDestinatario().getEmail());
        this.remetente = new Pessoa(agendaDTO.getRemetente().getId(), agendaDTO.getRemetente().getNome(), agendaDTO.getRemetente().getLogin(), agendaDTO.getRemetente().getEmail());;
    }

    public AgendaDTO toAgendaDTO() {
        return new AgendaDTO(this.id, this.envio, this.ultima_atualizacao, this.mensagem, this.destinatario.toPessoaDTO(), this.remetente.toPessoaDTO());
    }

    public void atualizarAgenda(String mensagem, LocalDateTime ultima_atualizacao) {
        this.mensagem = mensagem;
        this.ultima_atualizacao = ultima_atualizacao;
    }

}