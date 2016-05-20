package main.java.datas.responses;

import main.java.datas.responses.resources.GlimpseResource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 */
public class GlimpseResponse extends Response {

    private GlimpseResource[][] resources;
    private JSONArray jsonArray;
    private int askedRange;

    public GlimpseResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            askedRange = extras.getInt("asked_range");
            jsonArray = extras.getJSONArray("report");

            resources = new GlimpseResource[jsonArray.length()][];

            for(int i = 0; i < resources.length;i++){
                JSONArray resourceArray = jsonArray.getJSONArray(i);
                resources[i] = new GlimpseResource[resourceArray.length()];
                for(int j = 0; j < resources[i].length;j++){
                    if(i < 2){
                        JSONArray detail = resourceArray.getJSONArray(j);
                        resources[i][j] = new GlimpseResource(detail.getString(0),detail.getDouble(1));
                    }

                    else
                        resources[i][j] = new GlimpseResource(resourceArray.getString(j),0);
                }
            }
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public GlimpseResource[][] getResources(){
        return resources;
    }

    public int getAskedRange(){return askedRange;}
}

