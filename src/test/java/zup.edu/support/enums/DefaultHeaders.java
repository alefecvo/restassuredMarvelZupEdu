package zup.edu.support.enums;

import io.restassured.http.ContentType;

public enum DefaultHeaders {
    HEADER_CONTENT_TYPE("Content-Type", ContentType.JSON.toString());

    private String header;
    private String defaultValue;

    DefaultHeaders(String header, String defaultValue){
        this.header = header;
        this.defaultValue = defaultValue;
    }

    public String getHeader(){return header;}
    public String getDefaultValue(){return defaultValue;}
}
