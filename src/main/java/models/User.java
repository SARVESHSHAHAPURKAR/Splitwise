package models;

import java.util.Map;

public class User {

    String name;

    Map<String,Double> creditMappings;

    public User(String name, Map<String, Double> creditMappings) {
        this.name = name;
        this.creditMappings = creditMappings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getCreditMappings() {
        return creditMappings;
    }

    public void setCreditMappings(Map<String, Double> creditMappings) {
        this.creditMappings = creditMappings;
    }
}
