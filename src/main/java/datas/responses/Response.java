package main.java.datas.responses;

import main.java.datas.JSONData;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 18/05/2016.
 * Response to actions:
 *  -Fly
 *  -Heading
 *  -Stop
 *  -Land
 *  -Move_To
 */
public class Response extends JSONData{
    protected String status;
    protected int cost;
    protected JSONObject extras;

    private Error error;

    public Response(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        try{
            status = jsonObject.getString("status");
            cost = jsonObject.getInt("cost");
            extras = jsonObject.getJSONObject("extras");
        }

        catch(JSONException e){
            //e.printStackTrace();
            status = "ERROR";
            cost = 0;

            error = new Error(jsonObject);
            error.extractDatas();

        }
    }

    public int getCost(){
        return cost;
    }

    public String getStatus(){
        return status;
    }

    public JSONObject getExtras(){
        return extras;
    }

    public Error getError() {return error;}
}
