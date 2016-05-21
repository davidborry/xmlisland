package main.test.datas;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import main.java.XMLConverter;
import main.java.datas.*;
import main.java.datas.actions.Action;
import main.java.datas.events.header.Contract;
import main.java.datas.events.Event;
import main.java.datas.events.EventsList;
import main.java.datas.events.header.JSONHeader;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 20/05/2016.
 */
public class EventsListTest {

    @Test
    public void test(){
        int[] a = new int[] {1,2,3,4,5,6,7,8,9,10,11};

        for(int i = 1; i < a.length-1; i+=2)
            System.out.println(a[i] + "," + a[i+1]);
    }

    @Test
    public void JSONTest(){
        XMLConverter xmlConverter = new XMLConverter("resources/qdb.json");
        xmlConverter.extractJSON();

        Event[] events = xmlConverter.getEventsList().getEvents();

        for(int i = 1; i < events.length-1; i+=2)
            System.out.println(events[i].getJSONData().getClass() + " - " + events[i+1].getJSONData().getClass());
    }

    @Test
    public void headerTest(){
        XMLConverter xmlConverter = new XMLConverter("resources/qdb.json");
        xmlConverter.extractJSON();

        Event[] events = xmlConverter.getEventsList().getEvents();
        Event event = events[0];

        JSONHeader jsonHeader = (JSONHeader) event.getJSONData();

        assertEquals("S",jsonHeader.getHeading());
        assertEquals(25,jsonHeader.getMen());
        assertEquals(10000,jsonHeader.getBudget());

        Contract[] contracts = jsonHeader.getContracts();

        Contract c1 = contracts[0], c2 = contracts[1], c3 = contracts[2];
        assertEquals(100,c1.getAmount()); assertEquals("GLASS",c1.getResource());
        assertEquals(5000,c2.getAmount()); assertEquals("WOOD",c2.getResource());
        assertEquals(80,c3.getAmount()); assertEquals("FLOWER",c3.getResource());
    }

    @Test
    public void xmlTest(){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLConverter xmlConverter = new XMLConverter("resources/qdb.json");
        xmlConverter.extractJSON();

        xmlConverter.makeXML();

    }
}
