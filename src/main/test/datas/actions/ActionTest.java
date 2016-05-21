package main.test.datas.actions;

import jdk.internal.util.xml.XMLStreamException;
import main.java.datas.actions.Action;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 18/05/2016.
 */
public class ActionTest {
    Action action;
    String s = "{\"action\": \"fly\"}";
    JSONObject jsonObject;

    @Test
    public void flyTest(){

        try{
            jsonObject = new JSONObject(s);
            action = new Action(jsonObject);
            action.extractDatas();

            assertEquals("fly",action.getName());
        }

        catch(JSONException e){
            e.printStackTrace();
        }
        //System.out.println(s);
    }

    @Test
    public void scanTest(){
        try{
            s = "{\"action\": \"scan\"}";
            jsonObject = new JSONObject(s);
            action = new Action(jsonObject);
            action.extractDatas();

            assertEquals("scan",action.getName());
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void stopTest(){
        try{
            s = "{\"action\": \"stop\"}";
            jsonObject = new JSONObject(s);
            action = new Action(jsonObject);
            action.extractDatas();

            assertEquals("stop",action.getName());
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void exploreTest(){
        try{
            s = "{ \"action\": \"explore\" }";
            jsonObject = new JSONObject(s);
            action = new Action(jsonObject);
            action.extractDatas();

            assertEquals("explore",action.getName());
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void flyXmlTest(){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter writer = factory.createXMLStreamWriter(System.out);

            jsonObject = new JSONObject(s);
            action = new Action(jsonObject);
            action.extractDatas();

            action.writeDatas(writer);

        }

        catch (javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }

        catch(JSONException e){
            e.printStackTrace();
        }

    }

}
