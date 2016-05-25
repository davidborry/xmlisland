package main.java.datas.actions;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 18/05/2016.
 */
public class Land extends Action {
    private JSONObject parameters;
    private String creek;
    private int people;

    public Land(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            parameters = jsonObject.getJSONObject("parameters");
            creek = parameters.getString("creek");
            people = parameters.getInt("people");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{
            writeInitialDatas(writer);

            writeSimpleElement(writer,"creek",creek);
            writeSimpleElement(writer,"people",people+"");

            writer.writeEndElement();

        }

        catch(javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }
    }

    public String getCreek(){
        return creek;
    }

    public int getPeople(){
        return people;
    }
}
