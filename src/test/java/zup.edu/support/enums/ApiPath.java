package zup.edu.support.enums;

import static zup.edu.support.utils.GetProperties.getProp;

public enum ApiPath {
    PATH_COMICS(getProp("pathComics"));

    private String path;

    ApiPath(String path){
        this.path=path;
    }

    public String getPath(){return path;}
}
