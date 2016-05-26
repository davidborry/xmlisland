package main.java.datas.responses.resources;

/**
 * @author david
 * Used for GlimpseResponse
 * Represents a resource object with information about
 * name and biome rate if known.
 */
public class GlimpseResource{
    private String resource;
    private double rate; //0 = unknown

    public GlimpseResource(String resource, double rate){
        this.resource = resource;
        this.rate = rate;
    }

    public String getResource(){return resource;}
    public double getRate(){return rate;}
}
