package main.java.datas;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Justin on 18/05/2016.
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

    /**
     * All JSON championship reports are stored in a JSON array
     * We use it as a start point for conversion
     */
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

    /**
     *
     * @return String content from file
     * @throws IOException
     */
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
