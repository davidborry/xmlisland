package main.test.datas.responses;

import main.java.datas.responses.ScoutResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 19/05/2016.
 */
public class ScoutResponseTest {
    String s = "{ \"cost\": 5, \"extras\": { \"altitude\": 1, \"resources\": [\"FUR\", \"WOOD\"] }, \"status\": \"OK\" }";
    JSONObject jsonObject;
    ScoutResponse r;
    int altitude;
    String[] resources;

    @Test
    public void simpleTest(){
        try{
            jsonObject = new JSONObject(s);
            r = new ScoutResponse(jsonObject);
            r.getJSONDatas();

            assertEquals(5,r.getCost());
            assertEquals("OK",r.getStatus());

            altitude = r.getAltitude();
            resources = r.getResources();

            assertEquals(1,altitude);
            assertEquals("FUR",resources[0]);
            assertEquals("WOOD",resources[1]);

        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
