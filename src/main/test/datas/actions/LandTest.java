package main.test.datas.actions;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.actions.Land;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

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
            land.extractDatas();

            String name = land.getName();
            String creek = land.getCreek();
            int people = land.getPeople();

            assertEquals("land",name);
            assertEquals("id",creek);
            assertEquals(42,people);

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(System.out));

            land.writeDatas(writer);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
