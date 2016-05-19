package main.test.datas.responses;

import junit.framework.Assert;
import main.java.datas.responses.EchoResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 19/05/2016.
 */
public class EchoResponseTest {
    String s = "{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }";
    JSONObject jsonObject;
    EchoResponse r;

    @Test
    public void simpleTest(){
        try{
            jsonObject = new JSONObject(s);
            r = new EchoResponse(jsonObject);
            r.getJSONDatas();

            assertEquals(1,r.getCost());
            assertEquals("OK",r.getStatus());
            assertEquals(2,r.getRange());
            assertEquals("GROUND",r.getFound());
        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
