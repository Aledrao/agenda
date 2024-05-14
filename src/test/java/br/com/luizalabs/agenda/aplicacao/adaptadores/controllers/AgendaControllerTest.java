package br.com.luizalabs.agenda.aplicacao.adaptadores.controllers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AgendaControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void criarAgendaTest_Sucess() {

        RestAssured.given()
                .contentType("application/json")
                .body("{" +
                        "\"envio\": null," +
                        "    \"ultima_atualizacao\": null," +
                        "    \"mensagem\": \"Mais uma mensagem funcional.\"," +
                        "    \"destinatario\" : {" +
                        "        \"id\" : 1," +
                        "        \"nome\": null," +
                        "        \"login\": null," +
                        "        \"senha\": null" +
                        "    },\n" +
                        "    \"remetente\" : {" +
                        "        \"id\" : 2," +
                        "        \"nome\": null," +
                        "        \"login\": null," +
                        "        \"senha\": null" +
                        "    }" +
                        "}")
                .when()
                .post("http://localhost:" + port + "/agendas")
                .then().log().body()
                .statusCode(200);
    }

    @Test
    public void getAgendasPorIdTest_Sucess() {
        RestAssured
                .when()
                .get("http://localhost:" + port + "/agendas/20")
                .then().log().body()
                .contentType("application/json")
                .statusCode(200).and()
                .extract();
    }

    @Test
    public void getAgendaPorDestinatarioTest_Sucess() {
        RestAssured.given()
                .contentType("application/json")
                .body("{\n" +
                        "        \"id\" : 1,\n" +
                        "        \"nome\": null,\n" +
                        "        \"login\": null,\n" +
                        "        \"senha\": null\n" +
                        "}")
                .when()
                .get("http://localhost:" + port + "/agendas")
                .then().log().body()
                .statusCode(200);
    }

    @Test
    public void atualizarAgendaTest_Sucess() {
        RestAssured.given()
                .contentType("application/json")
                .body("{" +
                        "    \"mensagem\": \"Atualizando a nova mensagem de teste.\"" +
                        "}")
                .when()
                .put("http://localhost:" + port + "/agendas/20")
                .then().log().body()
                .statusCode(200);
    }

    @Test
    public void deletarAgendaTest_Sucess() {
        RestAssured.given()
                .contentType("application/json")
                .body("{" +
                        "    \"mensagem\": \"Atualizando a nova mensagem de teste.\"" +
                        "}")
                .when()
                .delete("http://localhost:" + port + "/agendas/20")
                .then().log().body()
                .statusCode(200);
    }

}