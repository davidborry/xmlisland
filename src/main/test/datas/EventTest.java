package main.test.datas;

import main.java.datas.Event;
import main.java.datas.actions.Action;
import main.java.datas.responses.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 20/05/2016.
 */
public class EventTest {

    String s1 = "{\n" +
            "  \"data\": {\"action\": \"fly\"},\n" +
            "  \"part\": \"Explorer\",\n" +
            "  \"time\": 1453057023285,\n" +
            "  \"meth\": \"takeDecision\"\n" +
            "}";

    String s2 = "{\n" +
            "  \"data\": {\n" +
            "    \"cost\": 5,\n" +
            "    \"extras\": {},\n" +
            "    \"status\": \"OK\"\n" +
            "  },\n" +
            "  \"part\": \"Engine\",\n" +
            "  \"time\": 1453057023285,\n" +
            "  \"meth\": \"takeDecision\"\n" +
            "}";

    JSONObject jsonObject;
    Event event;
    Action action;
    Response response;

    @Test
    public void eventTestAction(){
        try{
            jsonObject = new JSONObject(s1);
            event = new Event(jsonObject);

            event.extractDatas();
            action = new Action(event.getData());

            assertEquals("Explorer",event.getPart());
            assertEquals("1453057023285",event.getTime()+"");
            assertEquals("takeDecision",event.getMeth());

        }

        catch(JSONException e){e.printStackTrace();}
    }

    @Test
    public void eventTestResponse(){
        try{
            jsonObject = new JSONObject(s2);
            event = new Event(jsonObject);

            event.extractDatas();
            response = new Response(event.getData());

            assertEquals("Engine",event.getPart());
            assertEquals("1453057023285",event.getTime()+"");
            assertEquals("takeDecision",event.getMeth());
        }

        catch(JSONException e){e.printStackTrace();}
    }

}
