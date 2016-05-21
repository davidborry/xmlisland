package main.java.datas.events;

import main.java.datas.actions.*;
import main.java.datas.events.header.JSONHeader;
import main.java.datas.responses.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 20/05/2016.
 */
public class EventsList {

    private JSONArray jsonArray;
    private Event[] events;

    private Action currentAction;
    private Response currentResponse;

    public EventsList(JSONArray jsonArray){
        this.jsonArray = jsonArray;
        events = new Event[jsonArray.length()];
    }

    public void extractEvents(){
        makeHeader();
        for(int i = 1; i < jsonArray.length()-1; i+=2){
            try{
                Event actionEvent = new Event(jsonArray.getJSONObject(i));
                Event responseEvent = new Event(jsonArray.getJSONObject(i+1));

                actionEvent.extractDatas();
                responseEvent.extractDatas();

                String name = actionEvent.getData().getString("action");

                identify(name,actionEvent.getData(),responseEvent.getData());
                currentAction.extractDatas();
                currentResponse.extractDatas();

                //System.out.println(currentAction.getName() +"  " +currentResponse.getStatus());

                actionEvent.setJsonData(currentAction);
                responseEvent.setJsonData(currentResponse);

                events[i] = actionEvent;
                events[i+1] = responseEvent;
            }

            catch(JSONException e){
                e.printStackTrace();
            }
        }
    }

    public void identify(String name, JSONObject action, JSONObject response){
        switch(name){
            case "fly":
            case "stop":
                currentAction = new Action(action);
                currentResponse = new Response(response);
                break;

            case "heading":
            case "move_to":
                currentAction = new DirectionAction(action);
                currentResponse = new Response(response);
                break;

            case "echo":
                currentAction = new DirectionAction(action);
                currentResponse = new EchoResponse(response);
                break;

            case "scan":
                currentAction = new Action(action);
                currentResponse = new ScanResponse(response);
                break;

            case "land":
                currentAction = new Land(action);
                currentResponse = new Response(response);
                break;

            case "scout":
                currentAction = new DirectionAction(action);
                currentResponse = new ScoutResponse(response);
                break;

            case "glimpse":
                currentAction = new Glimpse(action);
                currentResponse = new GlimpseResponse(action);
                break;

            case "explore":
                currentAction = new Action(action);
                currentResponse = new ExploreResponse(response);
                break;

            case "exploit":
                currentAction = new Exploit(action);
                currentResponse = new ExploitResponse(response);
                break;

            case "transform":
                currentAction = new Transform(action);
                currentResponse = new TransformResponse(response);
                break;

            default:
                currentAction = new Action(action);
                currentResponse = new Response(response);
                break;
        }
    }

    public void makeHeader(){
        try{
            Event event = new Event(jsonArray.getJSONObject(0));
            event.extractDatas();

            JSONHeader jsonHeader = new JSONHeader(event.getData());
            jsonHeader.extractDatas();

            event.setJsonData(jsonHeader);

            events[0] = event;
        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }

    public Event[] getEvents(){
        return events;
    }
}
