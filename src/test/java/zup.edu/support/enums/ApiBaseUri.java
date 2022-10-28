package zup.edu.support.enums;

import static zup.edu.support.utils.GetProperties.getProp;

public enum ApiBaseUri {
    URI_MARVEL(getProp("baseurl"));

    private String path;

    ApiBaseUri(String path){this.path=path;}

    public String getPath(){return path;}
}
