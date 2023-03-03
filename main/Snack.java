package main;

public class Snack {
    private final String description;
    private final double cost;
    private final String provider;
    
    public Snack(String description, double cost, Player provider)
    {
        this.description = description;
        this.cost = cost;
        this.provider = provider.getName();
    }
    
    public String getDescription()
    {
        return this.description;
    }
    public double getCost()
    {
        return this.cost;
    }
    public String getProvider()
    {
        return this.provider;
    }
    
}
