package main.test.stats;

import main.java.stats.ActionList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 26/05/2016.
 */
public class ActionListTest {
    ActionList actionList;

    @Test
    public void Containstest(){
        actionList = new ActionList();
        System.out.println(actionList);

        assertEquals(true,actionList.contains("move_to"));
        assertEquals(false,actionList.contains("random"));

        assertEquals(1,actionList.indexOf("heading"));
        assertEquals(-1,actionList.indexOf("random"));
    }

    @Test
    public void addTest(){
        actionList = new ActionList();


        actionList.add("fly",4);
        actionList.add("echo",8);
        actionList.add("fly",4);
        actionList.add("land",15);
        actionList.add("fly",4);
        actionList.add("land",15);
        actionList.add("echo",8);
        actionList.add("echo",8);

        actionList.sortbyCost();
        actionList.makeProportions();

        System.out.println(actionList);

        assertEquals(12,actionList.getActionStats("fly").getTotalCost());
    }
}
