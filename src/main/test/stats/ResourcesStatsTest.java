package main.test.stats;

import main.java.stats.ResourceStats;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 26/05/2016.
 */
public class ResourcesStatsTest {
    ResourceStats resourceStats;

    @Test
    public void resourcesTest(){
        resourceStats = new ResourceStats("WOOD");

        resourceStats.add(4);
        resourceStats.add(2);
        resourceStats.add(1);

        assertEquals(7,resourceStats.getAmount());
    }
}
