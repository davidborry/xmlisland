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
 *  Response objects all have status, cost and extras datas
 */
public class Response extends JSONData{
    protected String status;
    protected int cost;
    protected JSONObject extras;

    //If we can't generate a Response from JSONDatas, then it's a championship error
    private Error error;

    public Response(JSONObject jsonObject){
        super(jsonObject);
    }

    private static int TOTAL_COST = 0;

    /**
     * First extract common response attributes
     * If one of them is missing, then the response type is
     * an error that prematurely ended the championship.
     */
    @Override
    public void extractDatas(){
        try{
            status = jsonObject.getString("status");
            cost = jsonObject.getInt("cost");
            extras = jsonObject.getJSONObject("extras");

            TOTAL_COST+=cost;
        }

        catch(JSONException e){
            //e.printStackTrace();
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

    /**
     * Writes initial datas
     * Like for fly action, we add css rule to only show
     * the first item of a fly action/response serie.
     * @param writer
     * @throws XMLStreamException
     */
    public void writeInitialDatas(javax.xml.stream.XMLStreamWriter writer) throws XMLStreamException{
        writer.writeStartElement("response");
        writer.writeAttribute("status",status);

        if(Action.NBFLY>=2)
            writer.writeAttribute("style","display:none;");


        writer.writeAttribute("cost",""+cost);
    }

    public static int getTotalCost(){return TOTAL_COST;}

}
