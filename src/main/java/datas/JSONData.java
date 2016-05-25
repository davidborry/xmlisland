package main.java.datas;

import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by david on 20/05/2016.
 */
public abstract class JSONData {
    protected JSONObject jsonObject;

    public JSONData(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public abstract void extractDatas();

    public abstract void writeDatas(XMLStreamWriter writer);

    public void writeSimpleElement(XMLStreamWriter writer,String tag, String content) throws XMLStreamException{
        writer.writeStartElement(tag);
        writer.writeCharacters(content);
        writer.writeEndElement();
    }
}
