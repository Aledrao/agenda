package br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades;

import br.com.luizalabs.agenda.dominio.Agenda;
import br.com.luizalabs.agenda.dominio.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "agenda")
@NoArgsConstructor
@Getter
@Setter
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private LocalDateTime envio;
    private String mensagem;
    private Pessoa destinatario;

    public AgendaEntity(Agenda agenda) {
        this.id = agenda.getId();
        this.envio = agenda.getEnvio();
        this.mensagem = agenda.getMensagem();
        this.destinatario = agenda.getDestinatario();
    }

    public void atualizar(Agenda agenda) {
        this.id = agenda.getId();
        this.envio = agenda.getEnvio();
        this.mensagem = agenda.getMensagem();
        this.destinatario = agenda.getDestinatario();
    }

    public Agenda toAgenda() {
        return new Agenda(this.id, this.envio, this.mensagem, this.destinatario);
    }

}
