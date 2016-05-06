package imac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import json.JSONObject;
import osValidator.OSValidator;
import processing.core.*;

/**
 * <b>Level class allow to load a level game from a JSON file.</b>
 * <p>It generates a Space and a Rocket player</p>
 * @author Pierre
 * @version 1.0
 */

public class Level {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * The level number
	 */
	private int levelNumber;
	
	/**
	 * Space environment with all meteors
	 */
	private Space space;
	
	/**
	 * Main character of the app
	 */
	private Rocket player;
	
	
	/**
	 * The constructor of Level
	 * It loads configuration files (player and level)
	 * to initialize the player and the space level
	 * 
	 * @param PApplet
	 * @param levelNumber
	 * 
	 * @since 1.0
	 */
	Level(PApplet p, int level){
		
		try {
			String jsonTextPlayer = loadPlayerFromJSONFile();
	        JSONObject jsonPlayer = new JSONObject(jsonTextPlayer); 
	        String playerName     = (String)jsonPlayer.getString("Player_Name");
	        String playerModel    = (String)jsonPlayer.getString("Player_Model");
	        
	        String jsonTextLevel  = loadLevelFromJSONFile(level);
			JSONObject jsonLevel  = new JSONObject(jsonTextLevel);  
			int playerScore       = (int)jsonLevel.getInt("Player_Score");
	        float playerSpeed     = (float)jsonLevel.getDouble("Player_Speed");
	        int playerLife        = (int)jsonLevel.getInt("Player_Life");
	        int levelNumber       = (int)jsonLevel.getInt("Level_Number");
	        int levelNbMeteors    = (int)jsonLevel.getInt("Level_NbMeteors");
	        
	        this.parent = p;
	        this.levelNumber = levelNumber;
	        this.space = new Space(this.parent, levelNbMeteors);
	        
	        if(OSValidator.isWindows()){
	        	playerModel = "../assets/models/" + playerModel;
	        }
	        else{
	        	playerModel = "./assets/models/" + playerModel;
	        }
	        
	        this.player = new Rocket(new Object3D(this.parent, playerModel), playerScore, playerSpeed, playerName, playerLife);
	        
	        System.out.print("Hello " + playerName + "! Let's start with level " + levelNumber  + "!\n");
        
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return rocket player
	 * 
	 * @since 1.0
	 */
	public Rocket getPlayer(){
		return this.player;
	}
	
	/**
	 * @return space
	 * 
	 * @since 1.0
	 */
	public Space getSpace(){
		return this.space;
	}
	
	/**
	 * Function to load player configuration file
	 * 
	 * @return String (player JSON text)
	 * 
	 * @since 1.0
	 */
	public String loadPlayerFromJSONFile() throws IOException{
		File f = new File("./assets/conf/player.json");
        if (f.exists()){
            InputStream is = new FileInputStream("./assets/conf/player.json");
            String jsonTxt = IOUtils.toString(is);
            return jsonTxt;
        }
        return null;
	}
	
	/**
	 * Function to load level configuration file
	 * 
	 * @param levelNumber
	 * @return String (level JSON text)
	 * 
	 * @since 1.0
	 */
	public String loadLevelFromJSONFile(int level) throws IOException{
		File f = new File("./assets/conf/levelNumber" + level + ".json");
        if (f.exists()){
            InputStream is = new FileInputStream("./assets/conf/levelNumber" + level + ".json");
            String jsonTxt = IOUtils.toString(is);
            return jsonTxt;
        }
        return null;
	}
	
	/**
	 * Function to display level (space and player)
	 * 
	 * @since 1.0
	 */
	public void display(){
		this.player.getModel().display();
		this.space.display();
	}
}
