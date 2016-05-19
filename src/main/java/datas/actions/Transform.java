package main.java.datas.actions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by david on 18/05/2016.
 */
public class Transform extends Action {
    private String [] keys;
    private JSONObject parameters;
    private HashMap<String,Integer> resources;

    public Transform(JSONObject jsonObject){
        super(jsonObject);
        resources = new HashMap();
    }

    @Override
    public void getJSONDatas(){
        super.getJSONDatas();

        try{
            parameters = jsonObject.getJSONObject("parameters");
            keys = JSONObject.getNames(parameters);
            for(int i = 0; i < keys.length;i++)
                resources.put(keys[i],parameters.getInt(keys[i]));
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public HashMap<String,Integer> getResources(){
        return resources;
    }
}