package main.java.datas.actions;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 18/05/2016.
 */
public class DirectionAction extends Action {
    protected JSONObject parameters;
    protected String direction;

    public DirectionAction(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            parameters = jsonObject.getJSONObject("parameters");
            direction = parameters.getString("direction");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){

    }

    public String getDirection(){
        return direction;
    }
}
