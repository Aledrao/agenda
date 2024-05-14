package br.com.luizalabs.agenda.dominio.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AgendaDTO {

    private Long id;
    private LocalDateTime envio;
    private LocalDateTime ultima_atualizacao;
    private String mensagem;
    private PessoaDTO destinatario;
    private PessoaDTO remetente;

}
