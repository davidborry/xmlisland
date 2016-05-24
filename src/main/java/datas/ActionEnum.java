package main.java.datas;

/**
 * Created by justin on 24/05/16.
 */
public enum ActionEnum {
    ECHO("echo"),
    FLY("fly"),
    LAND("land"),
    EXPLOIT("exploit"),
    EXPLORE("explore"),
    GLIMPSE("glimpse"),
    SCOUT("scout"),
    SCAN("scan"),
    HEADING("heading"),
    STOP("stop"),
    MOVE_TO("move_to"),
    TRANSFORM("transform");

    private String name;
    private int cost;

    ActionEnum(String name){
        this.name = name;
        this.cost = 0;
    }


    public String getAction(){ return this.name;}
    public void increment(int cost){ this.cost += cost;}
    public int getCost(){ return this.cost;}
}
