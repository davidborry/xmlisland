package main.test.datas.actions;

import main.java.datas.actions.Land;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 18/05/2016.
 */
public class LandTest {
    Land land;
    String s ="{ \"action\": \"land\", \"parameters\": { \"creek\": \"id\", \"people\": 42 }}";
    JSONObject jsonObject;

    @Test
    public void testGetJSONDatas() throws Exception {
        System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            land = new Land(jsonObject);
            land.getJSONDatas();

            String name = land.getName();
            String creek = land.getCreek();
            int people = land.getPeople();

            assertEquals("land",name);
            assertEquals("id",creek);
            assertEquals(42,people);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
