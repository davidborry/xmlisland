package main.java.datas.actions;

import main.java.datas.JSONData;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 18/05/2016.
 * Creates an Action object from a JSONObject and extracts all parameters
 */
public class Action extends JSONData {

    protected String name;

    public Action(JSONObject jsonObject){
        super(jsonObject);
    }


    @Override
    public void extractDatas(){

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
