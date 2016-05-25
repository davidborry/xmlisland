package main.java.datas.actions;

import main.java.datas.JSONData;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by david on 18/05/2016.
 * Creates an Action object from a JSONObject and extracts all parameters
 */
public class Action extends JSONData {

    protected String name;
    public static int NBFLY = 0;

    public Action(JSONObject jsonObject){
        super(jsonObject);
    }


    @Override
    public void extractDatas(){

        try{
            name = jsonObject.getString("action");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(XMLStreamWriter writer){

        try{
            writeInitialDatas(writer);
            writer.writeEndElement();

        }

        catch(javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }

    }

    public String getName(){
        return name;
    }

    public void writeInitialDatas(XMLStreamWriter writer) throws XMLStreamException{
        writer.writeStartElement("action");
        writer.writeAttribute("name",name);

        if(name.equals("fly")) {
            NBFLY++;
            if(NBFLY>=2)
                writer.writeAttribute("style","display:none;");
        }

        else
            NBFLY=0;
    }

}
