package main.test.datas;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.events.Event;
import main.java.datas.actions.Action;
import main.java.datas.responses.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

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

    @Test
    public void xmlTest(){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(System.out));

            jsonObject = new JSONObject(s1);
            event = new Event(jsonObject);

            event.extractDatas();
            action = new Action(event.getData());

            action.extractDatas();

            event.setJsonData(action);

            event.writeDatas(writer);

        }

        catch (javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

}
