package main.java.datas.responses;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 * Response to action Echo
 */
public class EchoResponse extends Response {
    private int range;
    private String found;

    public EchoResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){

        super.extractDatas();
        try{
            range = extras.getInt("range");
            found = extras.getString("found");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public int getRange(){
        return range;
    }

    public String getFound(){
        return found;
    }
}
