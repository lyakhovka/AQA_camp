package config;

import providers.data.ConfFromEnvironmentProvider;
import providers.data.ConfFromPropertiesProvider;
import providers.data.ConfigProvider;

public class Config extends BaseConfig {
// Config is implemented as a single tone

    private static Config instance;
    String target;

    private Config() {
        super();

        //Register all parameters we need for WebApiClient test run
        this.register("ENDPOINT_LOGIN");
        this.register("ENDPOINT_DASHBOARD");
        this.register("BASE_URL");
        this.register("EMAIL");
        this.register("PASSWORD");
        this.register("TOKENEXPIRES");
        this.register("CHROMEDRIVER");
        this.register("SIRIUSURL");
        this.register("LOGINPAGEHEADER");

        //Register parameters we need for TestConfig test run
        this.register("SOMETHING");
        this.register("PATH");

        target = System.getenv().get("TARGET");
        if (target==null) target="prod";
        System.out.println("TEST TARGET: " + target);

        //Define the providers priorities (analogue of 'Hierarchical provider' from the lecture
        //Registered parameters will ask their values from providers in the order providers are listed here.
        //If you change the providers order in the array, the result parameters values may be different.
        ConfigProvider[] providers = {new ConfFromEnvironmentProvider(), new ConfFromPropertiesProvider(target)};

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
