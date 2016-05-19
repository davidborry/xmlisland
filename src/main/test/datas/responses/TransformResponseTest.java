package main.test.datas.responses;

import main.java.datas.responses.TransformResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 19/05/2016.
 */
public class TransformResponseTest {
    String s = "{ \"cost\": 5, \"extras\": { \"production\": 1, \"kind\": \"GLASS\" },\"status\": \"OK\"}";
    JSONObject jsonObject;
    TransformResponse r;

    @Test
    public void simpleTest(){
        try{
            jsonObject = new JSONObject(s);
            r = new TransformResponse(jsonObject);
            r.getJSONDatas();

            assertEquals(5,r.getCost());
            assertEquals("OK",r.getStatus());

            assertEquals(1,r.getProduction());
            assertEquals("GLASS",r.getKind());

        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
