package main.test.datas.responses;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.responses.resources.GlimpseResource;
import main.java.datas.responses.GlimpseResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 19/05/2016.
 */
public class GlimpseResponseTest {
    String s = "{\"cost\": 3,\n" +
            "  \"extras\": {\n" +
            "    \"asked_range\": 4,\n" +
            "    \"report\": [\n" +
            "      [ [ \"BEACH\", 59.35 ], [ \"OCEAN\", 40.65 ] ],\n" +
            "      [ [ \"OCEAN\", 70.2  ], [ \"BEACH\", 29.8  ] ],\n" +
            "      [ \"OCEAN\", \"BEACH\" ],\n" +
            "      [ \"OCEAN\" ]\n" +
            "    ]\n" +
            "  },\n" +
            "  \"status\": \"OK\"}";

    JSONObject jsonObject;
    GlimpseResponse r;
    GlimpseResource[][] resources;

    @Test
    public void simpleTest(){
        try{
            jsonObject = new JSONObject(s);
            r = new GlimpseResponse(jsonObject);
            r.extractDatas();

            assertEquals(3,r.getCost());
            assertEquals("OK",r.getStatus());

            assertEquals(4,r.getAskedRange());
            resources = r.getResources();

            GlimpseResource a = resources[0][0], b =resources[0][1], c = resources[1][0], d = resources[1][1],
                    e = resources[2][0], f = resources[2][1], g = resources[3][0];

            assertEquals("BEACH",a.getResource());assertEquals(59.35,a.getRate());
            assertEquals("OCEAN",b.getResource());assertEquals(40.65,b.getRate());
            assertEquals("OCEAN",c.getResource());assertEquals(70.2,c.getRate());
            assertEquals("BEACH",d.getResource());assertEquals(29.8,d.getRate());
            assertEquals("OCEAN",e.getResource());assertEquals(0.0,e.getRate());
            assertEquals("BEACH",f.getResource());assertEquals(0.0,f.getRate());
            assertEquals("OCEAN",g.getResource());assertEquals(0.0,g.getRate());

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(System.out));

            r.writeDatas(writer);
        }

        catch (JSONException e){
            e.printStackTrace();
        }

        catch (XMLStreamException e){
            e.printStackTrace();
        }
    }
}
