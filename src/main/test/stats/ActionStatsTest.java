package main.test.stats;

import main.java.stats.ActionStats;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 26/05/2016.
 */
public class ActionStatsTest {
    ActionStats actionStats;

    @Test
    public void testActionStats(){
        actionStats = new ActionStats("fly");
       ActionStats actionStats2 = new ActionStats("heading");
        ActionStats actionStats3 = new ActionStats("echo");

        actionStats.newInstance(4);
        actionStats.newInstance(4);
        actionStats.newInstance(4);

        actionStats2.newInstance(8);
        actionStats2.newInstance(8);

        actionStats3.newInstance(12);



        actionStats.setProportion();
        actionStats.setCostProportion();

        System.out.println(actionStats);

        assertEquals(3,actionStats.getOccurences());
        assertEquals(12,actionStats.getTotalCost());

       assertEquals(50.0,actionStats.getProportion());
        assertEquals(30.0,actionStats.getCostProportion());
        assertEquals(true,actionStats.matches("fly"));

        assertEquals(6,ActionStats.getAllActions());
        assertEquals(40,ActionStats.getAllActionsCost());
    }
}
