package main.java.stats;

import main.java.datas.events.header.Contract;
import main.java.datas.events.header.JSONHeader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by david on 26/05/2016.
 */
public class Stats {
    private ActionList actionList;
    private ResourcesList resourcesList;
    private Contract[] contracts;

    public Stats(){
        actionList = new ActionList();
        resourcesList = new ResourcesList();

        contracts = new Contract[0];
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

    public void manageContract(Contract[] contracts){
        this.contracts = contracts;

        for(int i = 0; i < contracts.length; i++){
            if(resourcesList.contains(contracts[i].getResource())){
                contracts[i].validate();
            }

        }
    }

    @Override
    public String toString(){

        String s = "CHAMPIONSHIP REPORT\n";
        s+="Created on : " + getDate() +"\n\n";
        s += "////////////////////////////OVERVIEW////////////////////////////\n\n";
        s+=makeOverview()+"\n\n";

        actionList.sortbyCost();
        s += "////////////////////////////CONTRACTS////////////////////////////\n\n";
        s+= contractsStatus() + "\n\n";
        s += "////////////////////////////ACTIONS////////////////////////////\n\n";
        s+=actionList.toString()+"\n\n";

        if(resourcesList.size() >= 1) {
            s += "////////////////////////////RESOURCES////////////////////////////\n\n";
            s += resourcesList.toString();
        }

        return s;
    }

    public String contractsStatus(){
        String s = "";

        for(int i = 0; i < contracts.length; i++)
            s+=contracts[i].toString();

        return s;
    }

    /**
     * Actions and resources stats must already be sorted before
     * using this method
     */
    public String makeOverview(){
        String s = "";
        s+="TOTAL COST : " + ActionStats.getAllActionsCost() + "\n";
        s+="You spent the most of your budget in : " + actionList.getActionStats(0).getName() +
                " (" +actionList.getActionStats(0).getCostProportion() + "%)\n";
        actionList.sort();
        s+="Most used action : " + actionList.getActionStats(0).getName() +
                " (" +actionList.getActionStats(0).getProportion() + "%)\n";
        s+="Total distance on plane :" + actionList.getActionStats("fly").getOccurences()*3 + " tiles\n";
        s+="Total distance on foot :" + actionList.getActionStats("move_to").getOccurences() + " tiles\n";
        s+="You collected " + ResourceStats.getTotalResources() + " resources\n";
        if(resourcesList.size() >=1)
        s+="Most collected resource : " + resourcesList.getResourceStats(0).getName() +
                " ("+ resourcesList.getResourceStats(0).getAmount()+")\n";

        return s;
    }
    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}
