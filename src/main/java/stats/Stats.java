package main.java.stats;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by david on 26/05/2016.
 */
public class Stats {
    private ActionList actionList;
    private ResourcesList resourcesList;


    public Stats(){
        actionList = new ActionList();
        resourcesList = new ResourcesList();
    }

    public void addAction(String action,int cost){
        actionList.add(action,cost);
    }

    public void addResource(String resource, int amount){
        resourcesList.add(resource,amount);
    }

    public void removeResource(String resource, int amount){
        resourcesList.remove(resource,amount);
    }
    public void makeProportions(){
        actionList.makeProportions();
    }

    public void sort(){
        actionList.sortbyCost();
        resourcesList.sort();
    }
    public ActionList getActionList(){
        return actionList;
    }

    public ResourcesList getResourcesList() {return resourcesList;}

    @Override
    public String toString(){

        String s = "CHAMPIONSHIP REPORT\n";
        s+="Created on : " + getDate() +"\n\n";
        s += "////////////////////////////ACTIONS////////////////////////////\n\n";
        s+=actionList.toString()+"\n\n";
        s+="////////////////////////////RESOURCES////////////////////////////\n\n";
        s+=resourcesList.toString();

        return s;
    }

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}
