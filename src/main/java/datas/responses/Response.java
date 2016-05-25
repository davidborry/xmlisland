package main.java.datas.responses;

import jdk.internal.util.xml.XMLStreamWriter;
import main.java.datas.JSONData;
import main.java.datas.actions.Action;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;

/**
 * Created by david on 18/05/2016.
 * Response to actions:
 *  -Fly
 *  -Heading
 *  -Stop
 *  -Land
 *  -Move_To
 */
public class Response extends JSONData{
    protected String status;
    protected int cost;
    protected JSONObject extras;

    private Error error;

    public Response(JSONObject jsonObject){
        super(jsonObject);
    }

    private static int TOTAL_COST = 0, FLY_COST=0, HEADING_COST=0, STOP_COST=0, LAND_COST=0,MOVE_COST=0;

    @Override
    public void extractDatas(){
        try{
            status = jsonObject.getString("status");
            cost = jsonObject.getInt("cost");
            extras = jsonObject.getJSONObject("extras");

            TOTAL_COST+=cost;
        }

        catch(JSONException e){
            e.printStackTrace();
            status = "ERROR";
            cost = 0;

            error = new Error(jsonObject);
            error.extractDatas();

        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{

        writeInitialDatas(writer);
        writer.writeEndElement();

    }

    catch(javax.xml.stream.XMLStreamException e){
        e.printStackTrace();
    }}

    public int getCost(){
        return cost;
    }

    public String getStatus(){
        return status;
    }

    public JSONObject getExtras(){
        return extras;
    }

    public Error getError() {return error;}

    public void writeInitialDatas(javax.xml.stream.XMLStreamWriter writer) throws XMLStreamException{
        writer.writeStartElement("response");
        writer.writeAttribute("status",status);

        if(Action.NBFLY>=2)
            writer.writeAttribute("style","display:none;");


        writer.writeAttribute("cost",""+cost);
    }

    public static int getTotalCost(){return TOTAL_COST;}

    public void incrementActionCost(String name){
        TOTAL_COST+=cost;
        switch(name){
            case "fly":
                FLY_COST+=cost;
                break;
            case "heading":
                HEADING_COST+=cost;
                break;
            case "stop":
                STOP_COST+=cost;
                break;
            case "land":
                LAND_COST+=cost;
                break;
            case "move_to":
                MOVE_COST+=cost;
                break;

            default:
                break;
        }
    }

}
