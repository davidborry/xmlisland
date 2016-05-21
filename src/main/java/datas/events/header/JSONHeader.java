package main.java.datas.events.header;

import jdk.internal.util.xml.XMLStreamWriter;
import main.java.datas.JSONData;
import main.java.datas.events.header.Contract;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;

/**
 * Created by david on 20/05/2016.
 */
public class JSONHeader extends JSONData {
    private String heading;
    private int men, budget;
    private Contract[] contracts;
    private JSONArray contractsJSON;

    public JSONHeader(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        try{
            heading = jsonObject.getString("heading");
            men = jsonObject.getInt("men");
            budget = jsonObject.getInt("budget");

            contractsJSON = jsonObject.getJSONArray("contracts");
            contracts = new Contract[contractsJSON.length()];

            for(int i = 0; i < contracts.length;i++){
                contracts[i] = new Contract(contractsJSON.getJSONObject(i));
                contracts[i].extractDatas();
            }


        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeDatas(javax.xml.stream.XMLStreamWriter writer){
        try{
            writer.writeStartElement("data");

            writer.writeStartElement("heading");
            writer.writeCharacters(heading);
            writer.writeEndElement();

            writer.writeStartElement("men");
            writer.writeCharacters(men+"");
            writer.writeEndElement();

            for(int i = 0; i < contracts.length; i++){
                writer.writeEmptyElement("contract");
                writer.writeAttribute("amount",contracts[i].getAmount()+"");
                writer.writeAttribute("resource",contracts[i].getResource());
            }

            writer.writeEndElement();
        }

        catch (XMLStreamException e){
            e.printStackTrace();
        }
    }

    public String getHeading(){return heading;}
    public int getMen(){return men;}
    public int getBudget(){return budget;}
    public Contract[] getContracts(){return contracts;}
}
