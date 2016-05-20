package main.java.datas;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 20/05/2016.
 */
public class Contract extends JSONData {

    int amount;
    String resource;

    public Contract(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        try{
            this.amount = jsonObject.getInt("amount");
            this.resource = jsonObject.getString("resource");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public int getAmount(){
        return amount;
    }

    public String getResource(){
        return resource;
    }
}
