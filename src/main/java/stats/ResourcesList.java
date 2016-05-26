package main.java.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by david on 26/05/2016.
 *A list containing all different ResourceStats objects
 */

public class ResourcesList {
    private List<ResourceStats> list;

    public ResourcesList(){
        list = new ArrayList();
    }

    public void add(String name, int amount){
        if(!contains(name))
            list.add(new ResourceStats(name));
        list.get(indexOf(name)).add(amount);
    }


    /**
     * Called when a resource is used for crafting
     * @param name
     * @param amount
     */
    public void remove(String name, int amount){
        if(contains(name)) {
            list.get(indexOf(name)).remove(amount);

        if(list.get(indexOf(name)).getAmount() <= 0)
            list.remove(indexOf(name));
        }

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

    public ResourceStats getResourceStats(String name){
        if(contains(name))
            return list.get(indexOf(name));
        return null;
    }

    public ResourceStats getResourceStats(int i){
        if(i<list.size())
            return list.get(i);

        return null;
    }

    public int size(){
        return list.size();
    }

    /**
     * Sorts the list based on each item's amount. Decreasing order
     */
    public void sort(){
        Collections.sort(list, new Comparator<ResourceStats>() {
            @Override
            public int compare(ResourceStats as1, ResourceStats as2) {
                if(as1.getAmount() < as2.getAmount())
                    return 1;
                else if(as1.getAmount() == as2.getAmount())
                    return 0;
                return -1;
            }
        });
    }

    @Override
    public String toString(){
        String s="";
        for(int i = 0; i < list.size(); i++)
            s+=list.get(i).toString();
        return s;
    }
}
