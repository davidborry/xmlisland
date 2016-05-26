package main.java;

import main.java.datas.JSONFile;

import javax.xml.stream.XMLOutputFactory;
import java.io.IOException;

/**
 * Created by david on 17/05/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException{

        if(args.length > 0){
            String path;
            if(args.length >=2)
                path = args[1];
            else path = "output.xml";
            try {

                XMLConverter xmlConverter = new XMLConverter(args[0]);
                xmlConverter.extractJSON();
                xmlConverter.makeXML(path);
                xmlConverter.printStats("stats.log");

            }

            catch(NullPointerException e){

            }
        }


    }
}
