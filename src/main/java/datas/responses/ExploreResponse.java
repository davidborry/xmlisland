package main.java.datas.responses;

import jdk.internal.util.xml.XMLStreamWriter;
import main.java.datas.responses.resources.ExploredResource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Justin on 19/05/2016.
 * Extracts and converts all resources and creeks datas
 * from an explore action response
 * Creeks and resources are stored in two different arrays
 */
public class ExploreResponse extends Response {
    private ExploredResource[] resources;
    private String[] pois;
    private JSONArray resourcesJSON, poisJSON;


    public ExploreResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            resourcesJSON = extras.getJSONArray("resources");
            resources = new ExploredResource[resourcesJSON.length()];

            poisJSON = extras.getJSONArray("pois");
            pois = new String[poisJSON.length()];

            for(int i = 0; i < resources.length; i++)
                resources[i] = new ExploredResource(resourcesJSON.getJSONObject(i));

            for(int i = 0; i < pois.length; i++)
                pois[i] = poisJSON.getString(i);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    /**
     * Resources are represented as empty elements with 3 attributes (amount, type and condition)
     * @param writer
     */
    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{

        writeInitialDatas(writer);

        writer.writeStartElement("extras");

        writer.writeStartElement("resources");
        for(int i = 0; i < resources.length; i++){
            writer.writeEmptyElement("resource");
            writer.writeAttribute("amount",resources[i].getAmount());
            writer.writeAttribute("type",resources[i].getResource());
            writer.writeAttribute("cond",resources[i].getCond());
        }
        writer.writeEndElement();

        writer.writeStartElement("pois");
        for(int i = 0; i < pois.length; i++) {
            writeSimpleElement(writer,"creek",pois[i]);
        }
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndElement();

    }

    catch(javax.xml.stream.XMLStreamException e){
        e.printStackTrace();
    }}

    public ExploredResource[] getResources(){return resources;}
    public String[] getPois(){return pois;}
}
