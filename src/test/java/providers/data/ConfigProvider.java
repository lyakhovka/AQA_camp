package providers.data;

public interface ConfigProvider {
//By and large I need this interface to be able to store all providers in one array in the Config class (for 'Hierarchical provider')

    String getProperty(String key);

}
