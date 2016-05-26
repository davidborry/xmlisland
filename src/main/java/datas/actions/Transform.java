package main.java.datas.actions;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by david on 18/05/2016.
 */
public class Transform extends Action {
    private String [] keys;
    private JSONObject parameters;
    private HashMap<String,Integer> resources;

    public Transform(JSONObject jsonObject){
        super(jsonObject);
        resources = new HashMap();
    }

    /**
     * An HashMap is used for resources data.
     * Because we don't know the keys yet, we must
     * first initialize a key array based on the
     * content of JSONObject parameters
     */
    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            parameters = jsonObject.getJSONObject("parameters");
            keys = JSONObject.getNames(parameters);
            for(int i = 0; i < keys.length;i++)
                resources.put(keys[i],parameters.getInt(keys[i]));
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{
            writeInitialDatas(writer);

            for(int i = 0; i < keys.length; i++){
                writer.writeEmptyElement("resource");
                writer.writeAttribute("type",keys[i]);
                writer.writeAttribute("amount",resources.get(keys[i])+"");
            }

            writer.writeEndElement();
        }

        catch(javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }
    }

    public HashMap<String,Integer> getResources(){
        return resources;
    }
}
