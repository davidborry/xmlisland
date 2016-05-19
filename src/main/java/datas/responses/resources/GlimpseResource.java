package main.java.datas.responses.resources;

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
