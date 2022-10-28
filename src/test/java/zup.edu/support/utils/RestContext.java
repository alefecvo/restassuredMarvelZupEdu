package zup.edu.support.utils;

import io.cucumber.java.hu.De;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import zup.edu.support.enums.DefaultHeaders;
import zup.edu.support.enums.DefaultParams;

import java.util.HashMap;
import java.util.Map;

public class RestContext {
    private static RequestSpecification request;
    private static Response response;

    //iniciar requisição
    public static void initRequest(){
        RestAssured.useRelaxedHTTPSValidation();
        request = RestAssured.given();
    }

    //setar path padrão
    public static void setPath(String baseUri, String path){
        if (request == null){
            initRequest();
        }
        RestAssured.useRelaxedHTTPSValidation();
        request.baseUri(baseUri);
        request.basePath(path);
    }

    //setar header para requisição
    public static void setHeader(Map<String, String> contentHeader){
        request.headers(contentHeader);
    }


    public static void setHeaderDefault(){
        Map<String, String> contentHeader = new HashMap<>();
        contentHeader.put(
                DefaultHeaders.HEADER_CONTENT_TYPE.getHeader(),
                DefaultHeaders.HEADER_CONTENT_TYPE.getDefaultValue());
        setHeader(contentHeader);
    }

    public static void setParamsDefault(){
        Map<String, String> contentParams = new HashMap<>();
        contentParams.put(DefaultParams.PARAMS_APIKEY.getParamsPath(),DefaultParams.PARAMS_APIKEY.getParamsValue());
        contentParams.put(DefaultParams.PARAMS_TIMESTEMP.getParamsPath(),DefaultParams.PARAMS_TIMESTEMP.getParamsValue());
        contentParams.put(DefaultParams.PARAMS_HASH.getParamsPath(),DefaultParams.PARAMS_HASH.getParamsValue());
        setParams(contentParams);
    }

    //setar parâmetros para requisição
    public static void setPathParams(Map<String, String> params){
        request.pathParams(params);
    }

    public static void setParams(Map<String, ?> params){
        request.params(params);
    }

    public static void setQueryParams(Map<String, String> queryParams){
        request.queryParams(queryParams);
    }

    //setar body
    public static void setBody(String contentBody){
        request.body(contentBody);
    }

    //chamar métodos http
    public static void requestGet(){
        response = request.get();
    }

    public static void requestPut(){
        response = request.put();
    }

    public static void requestPost(){
        response = request.post();
    }

    public static void requestDelete(){
        response = request.delete();
    }

    public static void requestPatch(){
        response = request.patch();
    }

    //pegar resposta de requisição
    public static Response getResponse(){
        return response;
    }

    //imprimir logs
    public static void log(ValidatableResponse response){
        response.log().all();
    }

}
