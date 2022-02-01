package providers.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfFromPropertiesProvider implements ConfigProvider{
    //This provider is to read properties from .properties files

    protected static FileInputStream configFile;
    public static Properties PROPERTIES;

    public ConfFromPropertiesProvider(String target){
        try {
            configFile = new FileInputStream("src/test/resources/" + target + ".properties");
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
