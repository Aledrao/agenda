package br.com.luizalabs.agenda.infraestrutura.configuracao;

import br.com.luizalabs.agenda.dominio.adaptadores.services.AgendaServiceImp;
import br.com.luizalabs.agenda.dominio.portas.interfaces.AgendaServicePort;
import br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    AgendaServicePort agendaService(AgendaRepositoryPort agendaRepositoryPort) {
        return new AgendaServiceImp(agendaRepositoryPort);
    }

}
