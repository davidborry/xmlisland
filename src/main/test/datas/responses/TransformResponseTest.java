package main.test.datas.responses;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.responses.TransformResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.util.HashMap;

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
            r.extractDatas();

            assertEquals(5,r.getCost());
            assertEquals("OK",r.getStatus());

            assertEquals(1,r.getProduction());
            assertEquals("GLASS",r.getKind());

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
