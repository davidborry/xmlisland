package main.java.stats;

import java.text.DecimalFormat;

/**
 * Created by david on 26/05/2016.
 * Stats for explorer actions (cost, proportions etc...)
 */
public class ActionStats {
    protected String name;
    protected int occurences;
    protected int totalCost;
    protected double proportion;
    protected double costProportion;

    private static int ALLACTIONS = 0;
    private static int ALLACTIONSCOST = 0;

    public ActionStats(String name){
        this.name=name;
        this.occurences=0;
        this.totalCost=0;
    }

    public String getName(){
        return name;
    }

    public int getOccurences(){
        return occurences;
    }

    public void newInstance(int cost){
        occurences++;
        ALLACTIONS++;

        totalCost+=cost;
        ALLACTIONSCOST+=cost;
    }

    public int getTotalCost(){
        return totalCost;
    }

    public void setProportion(){
        this.proportion = round(((double)occurences/ALLACTIONS)*100);
    }

    public void setCostProportion(){
        this.costProportion = round(((double)totalCost/ALLACTIONSCOST)*100);
    }

    public double getProportion(){
        return this.proportion;
    }

    public double getCostProportion(){
        return this.costProportion;
    }

    public boolean matches(String name){
        return this.name.equals(name);
    }

    @Override
    public String toString(){
        return "["+name+"]  Occurences : " + occurences + " | Total cost : " + totalCost+ " | Proportion : " + proportion
                + "% | Cost proportion : " + costProportion +"% \n";
    }

    public static int getAllActions(){return ALLACTIONS;}
    public static int getAllActionsCost(){return ALLACTIONSCOST;}

    public double round(double n){
        return (double) Math.round(n*100)/100;
    }
}
