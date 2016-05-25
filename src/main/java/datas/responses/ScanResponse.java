package main.java.datas.responses;

import jdk.internal.util.xml.XMLStreamWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19/05/2016.
 * Used for action Scan
 */
public class ScanResponse extends Response{
    private String[] biomes, creeks;
    private JSONArray biomeJSON, creekJSON;


    public ScanResponse(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        super.extractDatas();

        try{
            biomeJSON = extras.getJSONArray("biomes");
            creekJSON = extras.getJSONArray("creeks");

            biomes = new String[biomeJSON.length()];
            creeks = new String[creekJSON.length()];

            for(int i = 0; i < biomes.length;i++)
                biomes[i] = biomeJSON.getString(i);

            for(int i = 0; i < creeks.length; i++)
                creeks[i] = creekJSON.getString(i);
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

            writer.writeStartElement("biomes");
            for(int i = 0; i < biomes.length; i++)
                writeSimpleElement(writer,"biome",biomes[i]);
            writer.writeEndElement();

            writer.writeStartElement("creeks");
            for(int i = 0; i < creeks.length; i++)
                writeSimpleElement(writer,"creek",creeks[i]);
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndElement();

        }

        catch(javax.xml.stream.XMLStreamException e){
            e.printStackTrace();
        }
    }

    public String[] getBiomes(){
        return biomes;
    }

    public String[] getCreeks(){
        return creeks;
    }
}
