package main.java.datas;

import org.json.JSONObject;

/**
 * Created by david on 20/05/2016.
 */
public abstract class JSONData {
    protected JSONObject jsonObject;

    public JSONData(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public abstract void extractDatas();
}
