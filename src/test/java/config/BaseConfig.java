package config;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseConfig {

    //This map stores <key, val> for registered parameters for test run
    Map<String, Object> registered = new HashMap<>();

    //Register parameter required for test run
    protected void register(String key) {
        registered.put(key, null);
    }

    //Get value of registered param
    public Object getRegisteredValue(String key) {

        Object registeredValue = this.registered.get(key);

        if (registeredValue != null) {
            return registeredValue;
        } else {
            if (!this.registered.containsKey(key)) {
                System.out.println(key + ": The variable is not registered");
            }
            return registeredValue;
        }
    }

    public BaseConfig() {
    }

}
