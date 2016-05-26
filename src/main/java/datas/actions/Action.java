package main.java.datas.actions;

import main.java.datas.JSONData;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by david on 18/05/2016.
 * Creates an Action object from a JSONObject and extracts all parameters
 * A simple Action object is used for:
 *  -Fly
 *  -Stop
 *  -scan
 *  -explore
 */
public class Action extends JSONData {

    protected String name;

    /*
    Used for css representation : We only display the first item of a fly serie so
    it does'nt become repetitive
     */
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

    /**
     * Writes first action attribute : name
     *
     * Particularity : In case of fly action, we add a style rule
     * based on the number of consecutive fly actions, so we only
     * display the first one.
     *
     * @param writer
     * @throws XMLStreamException
     */
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
