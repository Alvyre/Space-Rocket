package imac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import json.JSONObject;

public class Level {
	private int numberLevel;
	private Space space;
	//private Rocket player;
	
	Level() throws IOException{
		this.numberLevel = 1;
		File f = new File("./levelNumber" + this.numberLevel + ".json");
        if (f.exists()){
            InputStream is = new FileInputStream("file.json");
            String jsonTxt = IOUtils.toString(is);
            System.out.println(jsonTxt);
            JSONObject json = new JSONObject(jsonTxt);       
            String firstName = json.getString("firstName");
            System.out.println(firstName);
        }
	}
	
	Level(int level) throws IOException{
		this.numberLevel = level;
		File f = new File("./levelNumber" + this.numberLevel + ".json");
        if (f.exists()){
            InputStream is = new FileInputStream("file.json");
            String jsonTxt = IOUtils.toString(is);
            System.out.println(jsonTxt);
            JSONObject json = new JSONObject(jsonTxt);       
            String firstName = json.getString("firstName");
            System.out.println(firstName);
        }
	}
	
	public void loadLevel(int level) throws IOException{
		this.numberLevel = level;
		File f = new File("./levelNumber" + this.numberLevel + ".json");
        if (f.exists()){
            InputStream is = new FileInputStream("file.json");
            String jsonTxt = IOUtils.toString(is);
            System.out.println(jsonTxt);
            JSONObject json = new JSONObject(jsonTxt);       
            String firstName = json.getString("firstName");
            System.out.println(firstName);
        }
	}
	
	
}
