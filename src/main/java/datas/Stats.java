package main.java.datas;


import main.java.datas.actions.Action;

/**
 * Created by justin on 24/05/16.
 */
public class Stats {

    public void incrementCost(String action,int cost){
        for(ActionEnum ae: ActionEnum.values()){
            if(ae.getAction().equals(action)){
                ae.increment(cost);
                break;
            }
        }
    }

    public void get(){
        for(ActionEnum ae: ActionEnum.values()){
            System.out.println(ae.getCost());
        }
    }
}
