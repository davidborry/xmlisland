package main.java.datas.responses;

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
public class Response {
    protected String status;
    protected int cost;
    protected JSONObject jsonObject, extras;

    public Response(JSONObject jsonObject){
        this.jsonObject=jsonObject;
    }

    public void getJSONDatas(){
        try{
            status = jsonObject.getString("status");
            cost = jsonObject.getInt("cost");
            extras = jsonObject.getJSONObject("extras");
        }

        catch(JSONException e){
            e.printStackTrace();
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
}
