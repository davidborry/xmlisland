package main.java.datas.events.header;

import jdk.internal.util.xml.XMLStreamWriter;
import main.java.datas.JSONData;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;

/**
 * Created by david on 20/05/2016.
 */
public class Contract extends JSONData {

    private int amount;
    private String resource;
    private String status;

    public Contract(JSONObject jsonObject){
        super(jsonObject);
        this.status = "NOT ACCOMPLISHED";
    }

    public void validate(){
        status = "ACOMPLISHED";
    }

    @Override
    public void extractDatas(){
        try{
            this.amount = jsonObject.getInt("amount");
            this.resource = jsonObject.getString("resource");
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try {
            writer.writeEmptyElement("contract");
            writer.writeAttribute("amount", amount + "");
            writer.writeAttribute("resource", resource);
        }

        catch(XMLStreamException e){

        }
    }


    @Override
    public String toString(){
        return "Contract : " + amount + " " + resource + " | " +status + "\n" ;
    }

    public int getAmount(){
        return amount;
    }

    public String getResource(){
        return resource;
    }
}
