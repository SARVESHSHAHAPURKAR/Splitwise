package models;

import java.util.Map;

public class Expense {

    Double totalSpend;

    Map<String,Double> contributions;

    Map <String,Double> consumptions;

    public Expense(Double totalSpend, Map<String, Double> contributions, Map<String, Double> consumptions) {
        this.totalSpend = totalSpend;
        this.contributions = contributions;
        this.consumptions = consumptions;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public Map<String, Double> getContributions() {
        return contributions;
    }

    public void setContributions(Map<String, Double> contributions) {
        this.contributions = contributions;
    }

    public Map<String, Double> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(Map<String, Double> consumptions) {
        this.consumptions = consumptions;
    }
}
