package br.com.luizalabs.agenda.dominio;

import br.com.luizalabs.agenda.dominio.dtos.AgendaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Agenda {

    private Long id;
    private LocalDateTime envio;
    private String mensagem;
    private Pessoa destinatario;

    public Agenda(AgendaDTO agendaDTO) {
        this.id = agendaDTO.getId();
        this.envio = agendaDTO.getEnvio();
        this.mensagem = agendaDTO.getMensagem();
        this.destinatario = agendaDTO.getDestinatario();
    }

    public AgendaDTO toAgendaDTO() {
        return new AgendaDTO(this.id, this.envio, this.mensagem, this.destinatario);
    }

    public void atualizarAgenda(String mensagem) {
        this.mensagem = mensagem;
    }

}