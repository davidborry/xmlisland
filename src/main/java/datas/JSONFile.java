package main.java.datas;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by david on 18/05/2016.
 */
public class JSONFile {
    private String path;
    private String datas;
    JSONArray jsonDatas;

    public JSONFile(String path){
        this.path = path;
        datas = readFile();
        extractJson();
    }

    public void extractJson(){

        try{
            jsonDatas = new JSONArray(datas);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public JSONArray getJsonDatas(){
        return jsonDatas;
    }

    public String readFile(){
        String s = "";

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String c;
            while((c = bufferedReader.readLine()) != null){
                s+=c+"\n";
            }
        }

        catch(Exception e){
            s = "";
        }

        return s;
    }

    @Override
    public String toString(){
        return datas;
    }
}
