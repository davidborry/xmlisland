package main.java.datas;

import org.json.JSONObject;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by david on 20/05/2016.
 * Extracts datas from JSON object
 * and convert them into XML
 */
public abstract class JSONData {
    protected JSONObject jsonObject;

    public JSONData(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    /**
     * Extracts datas from JSON file
     */
    public abstract void extractDatas();

    /**
     * Converts datas in xml and stores them in a StreamWriter
     * @param writer
     */
    public abstract void writeDatas(XMLStreamWriter writer);

    /**
     * Used in order to write a simple xml tag with a string content
     * @param writer
     * @param tag
     * @param content
     * @throws XMLStreamException
     */
    public void writeSimpleElement(XMLStreamWriter writer,String tag, String content) throws XMLStreamException{
        writer.writeStartElement(tag);
        writer.writeCharacters(content);
        writer.writeEndElement();
    }
}
