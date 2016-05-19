package main.java.datas.responses;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 */
public class TransformResponse extends Response {
    private int production;
    private String kind;

    public TransformResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void getJSONDatas(){
        super.getJSONDatas();

        try{
            production = extras.getInt("production");
            kind = extras.getString("kind");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public int getProduction(){return production;}
    public String getKind(){return kind;}
}
