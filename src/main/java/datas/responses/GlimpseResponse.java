package main.java.datas.responses;

import jdk.internal.util.xml.XMLStreamWriter;
import main.java.datas.responses.resources.GlimpseResource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 * Extracts and converts 2-dimensional array containing biomes
 * informations with a given direction and range
 */
public class GlimpseResponse extends Response {

    private GlimpseResource[][] resources;
    private JSONArray jsonArray;
    private int askedRange;

    public GlimpseResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    /**
     * First we initialize the resource array based on jsonarray length.
     * Then we create a GlimpseResource for each biome in a given cell
     * If range is short (<2) we also extract extra attribute rate, else we
     * set it at 0
     */
    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            askedRange = extras.getInt("asked_range");
            jsonArray = extras.getJSONArray("report");

            resources = new GlimpseResource[jsonArray.length()][];

            for(int i = 0; i < resources.length;i++){
                JSONArray resourceArray = jsonArray.getJSONArray(i);
                resources[i] = new GlimpseResource[resourceArray.length()];
                for(int j = 0; j < resources[i].length;j++){
                    if(i < 2){
                        JSONArray detail = resourceArray.getJSONArray(j);
                        resources[i][j] = new GlimpseResource(detail.getString(0),detail.getDouble(1));
                    }

                    else
                        resources[i][j] = new GlimpseResource(resourceArray.getString(j),0);
                }
            }
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    /**
     * Hide rate attribute if value is 0
     * @param writer
     */
    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{

            writeInitialDatas(writer);
            writer.writeStartElement("extras");
            writeSimpleElement(writer,"askedRange",askedRange+"");
            writer.writeStartElement("report");

            for(int i = 0; i < resources.length; i++){
                writer.writeStartElement("biomes");
                writer.writeAttribute("range",i+1+"");
                for(int j = 0; j < resources[i].length; j++){
                    writer.writeStartElement("biome");

                    if(resources[i][j].getRate() != 0.0)
                        writer.writeAttribute("rate",resources[i][j].getRate()+"");

                    writer.writeCharacters(resources[i][j].getResource());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();

    }

    catch(javax.xml.stream.XMLStreamException e){
        e.printStackTrace();
    }}

    public GlimpseResource[][] getResources(){
        return resources;
    }

    public int getAskedRange(){return askedRange;}
}

