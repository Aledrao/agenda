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
    private LocalDateTime ultima_atualizacao;
    private String mensagem;
    private Pessoa destinatario;
    private Pessoa remetente;

    public AgendaEntity(Agenda agenda) {
        this.id = agenda.getId();
        this.envio = agenda.getEnvio();
        this.ultima_atualizacao = agenda.getUltima_atualizacao();
        this.mensagem = agenda.getMensagem();
        this.destinatario = agenda.getDestinatario();
        this.remetente = agenda.getRemetente();
    }

    public void atualizar(Agenda agenda) {
        this.id = agenda.getId();
        this.envio = agenda.getEnvio();
        this.ultima_atualizacao = agenda.getUltima_atualizacao();
        this.mensagem = agenda.getMensagem();
        this.destinatario = agenda.getDestinatario();
        this.remetente = agenda.getRemetente();
    }

    public Agenda toAgenda() {
        return new Agenda(this.id, this.envio, this.ultima_atualizacao, this.mensagem, this.destinatario, this.remetente);
    }

}
