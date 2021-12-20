package providers.data;

import java.util.Map;
import java.util.Properties;

public class ConfFromEnvironmentProvider implements ConfigProvider{

    public static Properties PROPERTIES;
    static {

        PROPERTIES = new Properties();
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            PROPERTIES.setProperty(envName, env.get(envName));
        }

    }
    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
