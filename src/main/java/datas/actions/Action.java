package main.java.datas.actions;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 18/05/2016.
 * Creates an Action object from a JSONObject and extracts all parameters
 */
public class Action {

    protected String name;
    protected JSONObject jsonObject;

    public Action(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }


    public void getJSONDatas(){

        try{
            name = jsonObject.getString("action");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public String getName(){
        return name;
    }


}
