package main.test.datas.responses;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.responses.ScanResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 19/05/2016.
 */
public class ScanResponseTest {
    String s = "{ \"cost\": 2, \"extras\": { \"biomes\": [\"GLACIER\", \"ALPINE\"], \"creeks\": []}, \"status\": \"OK\"}";
    JSONObject jsonObject;
    ScanResponse r;
    String[] biomes, creeks;

    @Test
    public void simpleTest(){
        try{
            jsonObject = new JSONObject(s);
            r = new ScanResponse(jsonObject);
            r.extractDatas();

            assertEquals(2,r.getCost());
            assertEquals("OK",r.getStatus());

            biomes = r.getBiomes();
            creeks = r.getCreeks();

            assertEquals("GLACIER",biomes[0]);
            assertEquals("ALPINE",biomes[1]);

            assertEquals(0,creeks.length);

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(System.out));

            r.writeDatas(writer);

        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
