package config;

import providers.data.ConfFromEnvironmentProvider;
import providers.data.ConfFromPropertiesProvider;
import providers.data.ConfigProvider;

public class Config extends BaseConfig {
// Config is implemented as a single tone

    private static Config instance;

    private Config() {
        super();

        //Register all parameters we need for test run
        this.register("LOGIN_PAGE_HEADER");
        this.register("DEMO_VAR");
        this.register("PATH");

        //Define the providers priorities (analogue of 'Hierarchical provider' from the lecture
        //Registered parameters will ask their values from providers in the order providers are listed here.
        //If you change the providers order in the array, the result parameters values may be different.
        ConfigProvider[] providers = {new ConfFromEnvironmentProvider(), new ConfFromPropertiesProvider()};

        //We are asking listed providers one by one if they have the value for a registered parameter.
        //If some parameter has already got its value from previous provider(s), it will not update the value from current provider.
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
