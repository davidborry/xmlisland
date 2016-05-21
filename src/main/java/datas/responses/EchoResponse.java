package main.java.datas.responses;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 * Response to action Echo
 */
public class EchoResponse extends Response {
    private int range;
    private String found;

    public EchoResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){

        super.extractDatas();
        try{
            range = extras.getInt("range");
            found = extras.getString("found");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{

            writeInitialDatas(writer);

            writer.writeStartElement("extras");

            writer.writeStartElement("range");
            writer.writeCharacters(range+"");
            writer.writeEndElement();

            writer.writeStartElement("found");
            writer.writeCharacters(found);
            writer.writeEndElement();


            writer.writeEndElement();
            writer.writeEndElement();

        }

        catch(javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }
    }

    public int getRange(){
        return range;
    }

    public String getFound(){
        return found;
    }

}
