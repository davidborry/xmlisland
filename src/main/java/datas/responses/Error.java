package main.java.datas.responses;

import main.java.datas.JSONData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 20/05/2016.
 */
public class Error extends JSONData {
    private String[] exceptions, messages;
    private String[][] stackTrace;

    private JSONArray jsonExceptions, jsonStackTrace, jsonMessage;

    public Error(JSONObject jsonObject){
        super(jsonObject);
    }

    @Override
    public void extractDatas(){
        try{
            jsonExceptions = jsonObject.getJSONArray("exception");
            jsonStackTrace = jsonObject.getJSONArray("stacktrace");
            jsonMessage = jsonObject.getJSONArray("message");

            exceptions = new String[jsonExceptions.length()];
            messages = new String[jsonMessage.length()];
            stackTrace = new String[jsonStackTrace.length()][];

            for(int i = 0; i < exceptions.length; i++)
                exceptions[i] = jsonExceptions.getString(i);

            for(int i = 0; i < messages.length; i++)
                messages[i] = jsonMessage.getString(i);

            for(int i = 0; i < stackTrace.length; i++){
                JSONArray jsonArray = jsonStackTrace.getJSONArray(i);
                stackTrace[i] = new String[jsonArray.length()];

                for(int j = 0; j < stackTrace[i].length; j++)
                    stackTrace[i][j] = jsonArray.getString(j);
            }


        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public String[] getExceptions(){return  exceptions;}
    public String[] getMessages(){ return  messages;}
    public String[][] getStackTrace(){return  stackTrace;}
}
