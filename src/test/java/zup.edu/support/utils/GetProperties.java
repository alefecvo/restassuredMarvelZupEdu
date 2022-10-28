package zup.edu.support.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static zup.edu.support.utils.Environments.getEnvironments;

public class GetProperties {
    private static final String DATA_CONFIG = "src/test/resources/";
    private static Properties properties;

    public static String getProp(String value){
        try {
            if (properties==null){
                GetProperties.properties = new Properties();
                GetProperties.properties.load(new FileInputStream(DATA_CONFIG + getEnvironments() + ".properties"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return GetProperties.properties.getProperty(value);
    }
}
