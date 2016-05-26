package main.test.stats;

import main.java.stats.ResourcesList;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 26/05/2016.
 */
public class ResourcesListTest {
    ResourcesList resourcesList;

    @Test
    public void testList(){
        resourcesList = new ResourcesList();

        resourcesList.add("WOOD",2);
        resourcesList.add("GLASS",1);
        resourcesList.add("WOOD",2);
        resourcesList.add("LEATHER",7);

        resourcesList.sort();
        System.out.println(resourcesList);
        assertEquals(4,resourcesList.getResourceStats("WOOD").getAmount());
    }
}
