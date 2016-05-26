package main.java.stats;

import main.java.stats.ActionStats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by david on 26/05/2016.
 */
public class ActionList {
    private List<ActionStats> list;

    public ActionList(){
        initializeActionStats();
    }


    public void add(String action, int cost){
        if(contains(action)) {
            ActionStats actionStats = list.get(indexOf(action));
            actionStats.newInstance(cost);
        }
    }

    public void makeProportions(){
        for(int i = 0; i < list.size(); i++){
            list.get(i).setProportion();
            list.get(i).setCostProportion();
        }
    }

    public ActionStats getActionStats(String name){
        if(contains(name))
            return list.get(indexOf(name));

        return null;
    }

    public ActionStats getActionStats(int i){
        if(i < list.size())
            return list.get(i);

        return null;
    }

    public int indexOf(String action){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).matches(action))
                return i;
        return -1;
    }

    public boolean contains(String action){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).matches(action))
                return true;
        return false;
    }
    public void initializeActionStats(){
        list = new ArrayList();
        list.add(new ActionStats("fly"));
        list.add(new ActionStats("heading"));
        list.add(new ActionStats("echo"));
        list.add(new ActionStats("scan"));
        list.add(new ActionStats("stop"));
        list.add(new ActionStats("land"));
        list.add(new ActionStats("move_to"));
        list.add(new ActionStats("scout"));
        list.add(new ActionStats("glimpse"));
        list.add(new ActionStats("explore"));
        list.add(new ActionStats("exploit"));
        list.add(new ActionStats("transform"));
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < list.size();i++)
            s+=list.get(i).toString();

        return s;
    }

    public void sort(){
        Collections.sort(list, new Comparator<ActionStats>() {
            @Override
            public int compare(ActionStats as1, ActionStats as2) {
                if(as1.getOccurences() < as2.getOccurences())
                    return 1;
                else if(as1.getOccurences() == as2.getOccurences())
                    return 0;
                return -1;
            }
        });
    }

    public void sortbyCost(){
        Collections.sort(list, new Comparator<ActionStats>() {
            @Override
            public int compare(ActionStats as1, ActionStats as2) {
                if(as1.getTotalCost() < as2.getTotalCost())
                    return 1;
                else if(as1.getTotalCost() == as2.getTotalCost())
                    return 0;
                return -1;
            }
        });
    }
}
