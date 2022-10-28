package zup.edu.service;


import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import zup.edu.support.enums.ApiBaseUri;
import zup.edu.support.enums.ApiPath;
import zup.edu.support.enums.DefaultHeaders;
import zup.edu.support.enums.DefaultParams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static zup.edu.support.utils.GetProperties.getProp;
import static zup.edu.support.utils.RestContext.*;

public class ComicsMarvelService {

    public static String getNameUrl(){
        String url = getProp("baseurl");
        return url;
    }
    public static String getNamePath(){
        String path = getProp("pathComics");
        return path;
    }

    //Fazer busca de todos heróis
    public static Response getAllComicsMarvel(){
        //iniciando requisição
        initRequest();
        //setpath URI + PATH
        setPath(ApiBaseUri.URI_MARVEL.getPath(), ApiPath.PATH_COMICS.getPath());
        //setHeader "content-type" + "json"
        setHeaderDefault();
        //setParams "ts, apikey, hash"
        setParamsDefault();
        //fazendo requisição
        requestGet();
        return getResponse();
    }

    public static void validateAllComics(ValidatableResponse response) throws IOException, JSONException {
        String retornaUsuarioCadastrado = new String((Files.readAllBytes(Paths.get("src/test/resources/payloads/getAllComics.json"))));

        JSONAssert.assertEquals(retornaUsuarioCadastrado,response.extract().asString(),false);

    }

}
