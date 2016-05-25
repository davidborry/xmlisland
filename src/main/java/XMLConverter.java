package main.java;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.datas.JSONFile;
import main.java.datas.events.Event;
import main.java.datas.events.EventsList;
import main.java.datas.responses.Response;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;

/**
 * Created by david on 21/05/2016.
 */
public class XMLConverter {

    private String fileName;
    private JSONFile jsonFile;
    private EventsList eventsList;

    public XMLConverter(String fileName){
        this.fileName = fileName;

        jsonFile = new JSONFile(fileName);
        eventsList = new EventsList(jsonFile.getJsonDatas());

    }

    public void extractJSON(){
        eventsList.extractEvents();
    }

    public EventsList getEventsList(){return eventsList;}

    public void makeXML(String path){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try{
           // XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(System.out));
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(new FileWriter(path)));
            Event[] events = eventsList.getEvents();

            writer.writeStartDocument();
            writer.writeProcessingInstruction("xml-stylesheet",
                    "type=\"text/css\" href=\"resources/style.css\"");

            writer.writeDTD("\n<!DOCTYPE championship SYSTEM \"resources/championship.dtd\">\n");

            writer.writeStartElement("championship");
            for(int i = 0; i < events.length; i++)
                events[i].writeDatas(writer);
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

        }

        catch(XMLStreamException e){
            e.printStackTrace();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeStats(){
        writeTotalCost();
    }

    public void writeTotalCost(){
        System.out.println("TOTAL COST : " + Response.getTotalCost());
    }
}
