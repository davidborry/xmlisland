package main.test.datas.actions;

import main.java.datas.actions.Transform;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 18/05/2016.
 */
public class TransformTest {
    Transform transform;
    String s ="{ \"action\": \"transform\", \"parameters\": { \"WOOD\": 6, \"QUARTZ\": 11 }}";
    JSONObject jsonObject;

    @Test
    public void testGetJSONDatas() throws Exception {
        System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            transform = new Transform(jsonObject);
            transform.getJSONDatas();

            String name = transform.getName();

            HashMap<String,Integer> resources = transform.getResources();
            int a = resources.get("WOOD");
            int b = resources.get("QUARTZ");

            assertEquals("transform",name);

            assertEquals(6,a);
            assertEquals(11,b);

        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
