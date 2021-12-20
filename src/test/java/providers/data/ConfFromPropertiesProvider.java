package providers.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfFromPropertiesProvider implements ConfigProvider{
    protected static FileInputStream configFile;
    public static Properties PROPERTIES;

   // private String confPath = "src/test/resources/" + System.getenv().get("TARGET");

    static {
        try {
            configFile = new FileInputStream("src/test/resources/" + System.getenv().get("TARGET") + ".properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (configFile != null) try {
                configFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
