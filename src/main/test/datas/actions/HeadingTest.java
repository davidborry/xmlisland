package main.test.datas.actions;

import main.java.datas.actions.Action;
import main.java.datas.actions.DirectionAction;
import main.java.datas.actions.Glimpse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by david on 18/05/2016.
 */
public class HeadingTest {
    DirectionAction action;
    String s ="{ \"action\": \"heading\", \"parameters\": { \"direction\": \"N\" } }";
    JSONObject jsonObject;

    @Test
    public void testGetJSONDatas() throws Exception {
       System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            action = new DirectionAction(jsonObject);
            action.getJSONDatas();

            String name = action.getName();
            String direction = action.getDirection();

            assertEquals("heading",name);
            assertEquals("N",direction);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testEcho(){
        s ="{ \"action\": \"echo\", \"parameters\": { \"direction\": \"N\" } }";
        System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            action = new DirectionAction(jsonObject);
            action.getJSONDatas();

            String name = action.getName();
            String direction = action.getDirection();

            assertEquals("echo",name);
            assertEquals("N",direction);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testMoveTo(){
        s ="{ \"action\": \"move_to\", \"parameters\": { \"direction\": \"N\" }  }";
        System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            action = new DirectionAction(jsonObject);
            action.getJSONDatas();

            String name = action.getName();
            String direction =  action.getDirection();

            assertEquals("move_to",name);
            assertEquals("N",direction);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testScout(){
        s ="{ \"action\": \"scout\", \"parameters\": { \"direction\": \"N\" } }";
        System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            action = new DirectionAction(jsonObject);
            action.getJSONDatas();

            String name = action.getName();
            String direction =  action.getDirection();

            assertEquals("scout",name);
            assertEquals("N",direction);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGlimpse(){
        s ="{ \"action\": \"glimpse\", \"parameters\": { \"direction\": \"W\", \"range\": 4 }  }";
        System.out.println(s);

        try{
            jsonObject = new JSONObject(s);
            action = new Glimpse(jsonObject);
            action.getJSONDatas();

            String name = action.getName();
            String direction =  action.getDirection();
            int range = ((Glimpse) action).getRange();

            assertEquals("glimpse",name);
            assertEquals("W",direction);
            assertEquals(4,range);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }
}