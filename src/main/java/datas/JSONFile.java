package main.java.datas;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by david on 18/05/2016.
 * Extracts JSON datas from a given
 * text file
 */
public class JSONFile {
    private String path;
    private String datas;
    JSONArray jsonDatas;

    public JSONFile(String path){
        this.path = path;

        try{
            datas = readFile();
            extractJson();
        }

        catch(Exception e){
            System.err.println("Le fichier " + path+ " n'existe pas ou ne correspond pas au bon format.");
        }

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

    public String readFile() throws IOException{
        String s = "";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String c;
        while((c = bufferedReader.readLine()) != null){
            s+=c+"\n";
        }


        return s;
    }

    @Override
    public String toString(){
        return datas;
    }
}
