package main.java.datas.events;

import main.java.datas.actions.*;
import main.java.datas.events.header.JSONHeader;
import main.java.datas.responses.*;
import main.java.stats.Stats;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by david on 20/05/2016.
 */
public class EventsList {

    private JSONArray jsonArray;
    private Event[] events;

    private Action currentAction;
    private Response currentResponse;

    private Stats stats;

    public EventsList(JSONArray jsonArray){
        this.jsonArray = jsonArray;
        events = new Event[jsonArray.length()];

        stats = new Stats();
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

                updateStats();
                //System.out.println(currentAction.getName() +"  " +currentResponse.getStatus());

                actionEvent.setJsonData(currentAction);

                if(currentResponse.getStatus().equals("ERROR"))
                    responseEvent.setJsonData(currentResponse.getError());
                else
                    responseEvent.setJsonData(currentResponse);

                events[i] = actionEvent;
                events[i+1] = responseEvent;

            }

            catch(JSONException e){
                e.printStackTrace();
            }
        }

        stats.makeProportions();
        stats.sort();
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
                currentResponse = new GlimpseResponse(response);
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

    public void updateStats(){
        String action = currentAction.getName();
        int cost = currentResponse.getCost();
        stats.addAction(action,cost);

        updateResourceStats(action);
    }

    public void updateResourceStats(String action){
        if(action.equals("exploit")){
            Exploit exploit = (Exploit) currentAction;
            ExploitResponse exploitResponse = (ExploitResponse) currentResponse;

            String resource = exploit.getResource();
            int amount = exploitResponse.getAmount();

            stats.addResource(resource,amount);
        }

        else if(action.equals("transform")){
            Transform transform = (Transform) currentAction;
            TransformResponse transformResponse = (TransformResponse) currentResponse;

            HashMap<String,Integer> resources = transform.getResources();
            String[] keys = new String[resources.keySet().size()];
            resources.keySet().toArray(keys);

            for(int i = 0; i < resources.size(); i++)
                if(i < keys.length)
                    stats.removeResource(keys[i],resources.get(keys[i]));

            String kind = transformResponse.getKind();
            int production = transformResponse.getProduction();

            stats.addResource(kind,production);
        }
    }

    public Stats getStats(){return stats;}

    public Event[] getEvents(){
        return events;
    }
}
