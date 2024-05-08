package br.com.luizalabs.agenda.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Agenda {

    private Long id;
    private LocalDateTime dataHoraEnvio;
    private String mensagem;
    private Pessoa destinatario;

}
