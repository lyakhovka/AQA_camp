package providers.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream configFile;
    protected static Properties PROPERTIES;

    static {
        try {
            configFile = new FileInputStream("src/test/resources/commonConf.properties");
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

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
