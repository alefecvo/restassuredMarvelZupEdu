package zup.edu.support.enums;

import static zup.edu.support.utils.GetProperties.getProp;

public enum DefaultParams {
    PARAMS_TIMESTEMP("ts",getProp("timestamp")),
    PARAMS_APIKEY("apikey",getProp("apikey")),
    PARAMS_HASH("hash",getProp("hash"));

    private String path;
    private String value;

    DefaultParams(String path, String value){
        this.path = path;
        this.value = value;
    }

    public String getParamsPath(){return path;}
    public String getParamsValue(){return value;}

}
