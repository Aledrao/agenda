package br.com.luizalabs.agenda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan({"br.com.luizalabs.agenda.dominio.portas.repositories.AgendaRepositoryPort"})
class AgendaApplicationTests {

	@Test
	void contextLoads() {
	}

}
