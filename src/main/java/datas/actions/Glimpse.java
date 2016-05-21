package main.java.datas.actions;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;

/**
 * Created by david on 18/05/2016.
 */
public class Glimpse extends DirectionAction {

    private int range;

    public Glimpse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            range = parameters.getInt("range");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{
            writeInitialDatas(writer);

            writer.writeEmptyElement("parameters");
            writer.writeAttribute("direction",direction);
            writer.writeAttribute("range",range+"");

            writer.writeEndElement();

        }

        catch(XMLStreamException e){
            e.printStackTrace();
        }
    }

    public int getRange(){
        return range;
    }
}
