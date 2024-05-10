package br.com.luizalabs.agenda.infraestrutura.configuracao;

import br.com.luizalabs.agenda.dominio.adaptadores.services.AgendaServiceImp;
import br.com.luizalabs.agenda.dominio.portas.interfaces.AgendaServicePort;
import br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class BeanConfiguration {

    private static final String dateFormat = "dd/MM/yyyy";
    private static final String dateTimeFormat = "dd/MM/yyyy HH:mm:ss";

    @Bean
    AgendaServicePort agendaService(AgendaRepositoryPort agendaRepositoryPort) {
        return new AgendaServiceImp(agendaRepositoryPort);
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

}
