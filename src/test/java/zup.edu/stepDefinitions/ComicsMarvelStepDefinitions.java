package zup.edu.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.ValidatableResponse;
import org.json.JSONException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static zup.edu.service.ComicsMarvelService.*;
import static zup.edu.support.utils.RestContext.getResponse;


public class ComicsMarvelStepDefinitions {
    ValidatableResponse response;

    @Dado("que desejo buscar dados de todos quadrinhos da marvel")
    public void queDesejoBuscarDadosDeTodosQuadrinhosDaMarvel() {
        System.out.println("Iniciando conexão com a API Marvel -> " + getNameUrl());
    }

    @Quando("fazer requisição para rota GET Comics")
    public void fazerRequisiçãoParaRotaGETComics() {
        System.out.println("Fazendo requisição na API Marvel na rota -> " + getNamePath());
        getAllComicsMarvel();
    }

    @Então("valido retorno dos dados de todos quadrinhos com sucesso")
    public void validoRetornoDosDadosDeTodosQuadrinhosComSucesso() throws JSONException, IOException {
        //Recebendo resultado da requisição
        System.out.println("Obtendo resposta da requisição... ");
        response = getResponse().then();

        //Imprimindo e validando mensagem = Ok
        System.out.println("Imprimindo e validando mensagem -> " + response.extract().jsonPath().getString("status"));
        assertEquals("Ok", response.extract().jsonPath().getString("status"));

        //Imprimindo e validando statuscode = 200
        System.out.println("Imprimindo e validando status code -> " + response.extract().jsonPath().getString("code"));
        response = getResponse().then().statusCode(200);

        //Validando retorno da requisição com arquivo getAllComics.json
        validateAllComics(response);

        //Recebendo resultado da requisição e imprimindo logs
        //        System.out.println("Obtendo Logs... ");
        //        response = getResponse().then().log().all();

    }
}
