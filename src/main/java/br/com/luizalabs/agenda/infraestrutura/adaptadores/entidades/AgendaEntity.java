package br.com.luizalabs.agenda.infraestrutura.adaptadores.entidades;

import br.com.luizalabs.agenda.dominio.Agenda;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
@NoArgsConstructor
public class AgendaEntity {

    @SequenceGenerator(name = "agenda_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_id_seq")
    @Id
    private Long id;
    private LocalDateTime envio;
    private LocalDateTime ultima_atualizacao;
    private String mensagem;
    @ManyToOne
    @JoinColumn(name = "destinatario")
    private PessoaEntity destinatario;
    @ManyToOne
    @JoinColumn(name = "remetente")
    private PessoaEntity remetente;

    public AgendaEntity(Agenda agenda) {
        this.id = agenda.getId();
        this.envio = agenda.getEnvio();
        this.ultima_atualizacao = agenda.getUltima_atualizacao();
        this.mensagem = agenda.getMensagem();
        this.destinatario = new PessoaEntity(agenda.getDestinatario());
        this.remetente = new PessoaEntity(agenda.getRemetente());
    }

    public void atualizar(Agenda agenda) {
        this.id = agenda.getId();
        this.envio = agenda.getEnvio();
        this.ultima_atualizacao = agenda.getUltima_atualizacao();
        this.mensagem = agenda.getMensagem();
        this.destinatario = new PessoaEntity(agenda.getDestinatario());
        this.remetente = new PessoaEntity(agenda.getRemetente());
    }

    public Agenda toAgenda() {
        return new Agenda(this.id, this.envio, this.ultima_atualizacao, this.mensagem, new PessoaEntity().toPessoa(destinatario), new PessoaEntity().toPessoa(remetente));
    }

}
