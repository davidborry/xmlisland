package main.java.datas.responses;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Justin on 19/05/2016.
 * Extracts and converts production and kind value from JSONDatas
 */
public class TransformResponse extends Response {
    private int production;
    private String kind;

    public TransformResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            production = extras.getInt("production");
            kind = extras.getString("kind");
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

            writeSimpleElement(writer,"production",production+"");
            writeSimpleElement(writer,"kind",kind);

            writer.writeEndElement();
            writer.writeEndElement();

        }

        catch(javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }
    }

    public int getProduction(){return production;}
    public String getKind(){return kind;}
}
