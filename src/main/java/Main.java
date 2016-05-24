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
            try {

                XMLConverter xmlConverter = new XMLConverter(args[0]);
                xmlConverter.extractJSON();
                xmlConverter.makeXML();
                xmlConverter.writeStats();
            }

            catch(NullPointerException e){

            }
        }


    }
}
