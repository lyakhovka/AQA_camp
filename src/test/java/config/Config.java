package config;

import providers.data.ConfFromEnvironmentProvider;
import providers.data.ConfFromPropertiesProvider;
import providers.data.ConfigProvider;

public class Config extends BaseConfig {

    private static Config instance;

    private Config() {
        super();
        this.register("LOGIN_PAGE_HEADER");
        this.register("DEMO_VAR");
        this.register("PATH");

        ConfigProvider[] providers = {new ConfFromEnvironmentProvider(), new ConfFromPropertiesProvider()};

        for (int i = 0; i < providers.length; i++) {
            for (String key : this.registered.keySet()) {
                if (registered.get(key) == null)
                    this.registered.put(key, providers[i].getProperty(key));
            }
        }

    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

}
