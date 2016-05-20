package main.java.datas;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 20/05/2016.
 */
public class Event extends JSONData {
    private JSONObject data;
    private String part, meth;
    private long time;

    private JSONData jsonData;

    public Event(JSONObject jsonObject){
        super(jsonObject);

    }

    @Override
    public void extractDatas(){
        try{
            data = jsonObject.getJSONObject("data");
            part = jsonObject.getString("part");
            time = jsonObject.getLong("time");
            meth = jsonObject.getString("meth");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public JSONObject getData(){
        return data;
    }

    public String getPart(){return part;}
    public String getMeth(){return meth;}
    public long getTime(){return time;}

    public void setJsonData(JSONData jsonData){this.jsonData = jsonData;}

    public JSONData getJSONData(){ return jsonData;}
}
