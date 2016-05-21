package main.test.datas.actions;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.actions.Transform;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
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
            transform.extractDatas();

            String name = transform.getName();

            HashMap<String,Integer> resources = transform.getResources();
            int a = resources.get("WOOD");
            int b = resources.get("QUARTZ");

            assertEquals("transform",name);

            assertEquals(6,a);
            assertEquals(11,b);

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(System.out));

            transform.writeDatas(writer);

        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
