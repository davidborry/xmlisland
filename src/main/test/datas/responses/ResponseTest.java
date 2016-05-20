package main.test.datas.responses;

import main.java.datas.responses.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 19/05/2016.
 */
public class ResponseTest {
    String s = "{ \"cost\": 4, \"extras\": {}, \"status\": \"OK\" }";
    JSONObject jsonObject;
    Response r;

    @Test
    public void simpleTest(){
        try{
            jsonObject = new JSONObject(s);
            r = new Response(jsonObject);
            r.extractDatas();

            assertEquals(4,r.getCost());
            assertEquals("OK",r.getStatus());

        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void polymorphismTest(){


    }
}
