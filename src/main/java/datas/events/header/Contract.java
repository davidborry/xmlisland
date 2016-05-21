package main.java.datas.events.header;

import jdk.internal.util.xml.XMLStreamWriter;
import main.java.datas.JSONData;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 20/05/2016.
 */
public class Contract extends JSONData {

    private int amount;
    private String resource;

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

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){}

    public int getAmount(){
        return amount;
    }

    public String getResource(){
        return resource;
    }
}
