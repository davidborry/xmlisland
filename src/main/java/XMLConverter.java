package main.java;

import main.java.datas.JSONFile;
import main.java.datas.events.EventsList;

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
}
