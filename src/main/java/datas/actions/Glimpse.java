package main.java.datas.actions;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 18/05/2016.
 */
public class Glimpse extends DirectionAction {

    private int range;

    public Glimpse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            range = parameters.getInt("range");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public int getRange(){
        return range;
    }
}
