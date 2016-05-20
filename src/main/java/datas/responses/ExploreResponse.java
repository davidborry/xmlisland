package main.java.datas.responses;

import main.java.datas.responses.resources.ExploredResource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 */
public class ExploreResponse extends Response {
    private ExploredResource[] resources;
    private String[] pois;
    private JSONArray resourcesJSON, poisJSON;


    public ExploreResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            resourcesJSON = extras.getJSONArray("resources");
            resources = new ExploredResource[resourcesJSON.length()];

            poisJSON = extras.getJSONArray("pois");
            pois = new String[poisJSON.length()];

            for(int i = 0; i < resources.length; i++)
                resources[i] = new ExploredResource(resourcesJSON.getJSONObject(i));

            for(int i = 0; i < pois.length; i++)
                pois[i] = poisJSON.getString(i);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public ExploredResource[] getResources(){return resources;}
    public String[] getPois(){return pois;}
}