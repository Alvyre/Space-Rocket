package imac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import imac.hud.HUD;
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
	
	private HUD hud;
	
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
			String jsonTextPlayer     = loadPlayerFromJSONFile();
	        JSONObject jsonPlayer     = new JSONObject(jsonTextPlayer); 
	        String playerName         = (String)jsonPlayer.getString("Player_Name");
	        String playerModel        = (String)jsonPlayer.getString("Player_Model");
	        
	        String jsonTextLevel      = loadLevelFromJSONFile(level);
			JSONObject jsonLevel      = new JSONObject(jsonTextLevel);  
			JSONObject playerPosition = (JSONObject)jsonLevel.getJSONObject("Player_Position");
			float playerPositionX     = (float)playerPosition.getDouble("x");
			float playerPositionY     = (float)playerPosition.getDouble("y");
			float playerPositionZ     = (float)playerPosition.getDouble("z");
			JSONObject playerScale    = (JSONObject)jsonLevel.getJSONObject("Player_Scale");
			float playerScaleX        = (float)playerScale.getDouble("x");
			float playerScaleY        = (float)playerScale.getDouble("y");
			float playerScaleZ        = (float)playerScale.getDouble("z");
			int playerScore           = (int)jsonLevel.getInt("Player_Score");
	        float playerSpeed         = (float)jsonLevel.getDouble("Player_Speed");
	        int playerLife            = (int)jsonLevel.getInt("Player_Life");
	        int levelNumber           = (int)jsonLevel.getInt("Level_Number");
	        int levelNbMeteors        = (int)jsonLevel.getInt("Level_NbMeteors");
	        JSONObject levelSpeed = (JSONObject)jsonLevel.getJSONObject("Level_SpeedMeteor");
	        float levelSpeedMin = (float)levelSpeed.getDouble("min");
	        float levelSpeedMax = (float)levelSpeed.getDouble("max");
	        
	        this.parent = p;
	        this.levelNumber = levelNumber;
	        this.space = new Space(this.parent, levelNbMeteors, levelSpeedMin, levelSpeedMax);
	        
	        if(OSValidator.isWindows()){
	        	playerModel = "../assets/models/" + playerModel;
	        }
	        else{
	        	playerModel = "./assets/models/" + playerModel;
	        }
	        
	        this.player = new Rocket(new Object3D(this.parent, playerModel, playerPositionX, playerPositionY, playerPositionZ, playerScaleX, playerScaleY, playerScaleZ), playerScore, playerSpeed, playerName, playerLife);
	        welcomeToSpaceRocket(playerName);
	        hud = new HUD();
        
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return level number
	 * 
	 * @since 1.0
	 */
	public int getLevelNumber(){
		return this.levelNumber;
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
	 * @throws IOException 
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
	 * @throws IOException 
	 * 
	 * @since 1.0
	 */
	public String loadLevelFromJSONFile(int level) throws IOException{
		File f = new File("./assets/conf/level" + level + ".json");
        if (f.exists()){
            InputStream is = new FileInputStream("./assets/conf/level" + level + ".json");
            String jsonTxt = IOUtils.toString(is);
            return jsonTxt;
        }
        return null;
	}
	
	/**
	 * Allow to restart level
	 * It reloads the level from the configuration file
	 * 
	 * @since 1.0
	 */
	public void restartLevel(){
		try {
			String jsonTextLevel  = loadLevelFromJSONFile(this.levelNumber);
			JSONObject jsonLevel  = new JSONObject(jsonTextLevel);  
			JSONObject playerPosition = (JSONObject)jsonLevel.getJSONObject("Player_Position");
			float playerPositionX     = (float)playerPosition.getDouble("x");
			float playerPositionY     = (float)playerPosition.getDouble("y");
			float playerPositionZ     = (float)playerPosition.getDouble("z");
			int playerScore       = (int)jsonLevel.getInt("Player_Score");
	        float playerSpeed     = (float)jsonLevel.getDouble("Player_Speed");
	        int playerLife        = (int)jsonLevel.getInt("Player_Life");
	        int levelNumber       = (int)jsonLevel.getInt("Level_Number");
	        int levelNbMeteors    = (int)jsonLevel.getInt("Level_NbMeteors");
	        JSONObject levelSpeed = (JSONObject)jsonLevel.getJSONObject("Level_SpeedMeteor");
	        float levelSpeedMin = (float)levelSpeed.getDouble("min");
	        float levelSpeedMax = (float)levelSpeed.getDouble("max");
	        
	        this.levelNumber = levelNumber;
	        this.space = new Space(this.parent, levelNbMeteors, levelSpeedMin, levelSpeedMax);
	        this.player.getModel().setPosition(playerPositionX, playerPositionY, playerPositionZ);
	        this.player.setLife(playerLife);
	        this.player.setScore(playerScore);
	        this.player.setSpeed(playerSpeed);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Allow to load from the configuration file
	 * It can be useful to change levels
	 * 
	 * @return String (level JSON text)
	 * 
	 * @since 1.0
	 */
	public void loadLevel(int level){
		try {
			String jsonTextLevel  = loadLevelFromJSONFile(level);
			JSONObject jsonLevel  = new JSONObject(jsonTextLevel);  
			int playerScore       = (int)jsonLevel.getInt("Player_Score");
	        float playerSpeed     = (float)jsonLevel.getDouble("Player_Speed");
	        int playerLife        = (int)jsonLevel.getInt("Player_Life");
	        int levelNumber       = (int)jsonLevel.getInt("Level_Number");
	        int levelNbMeteors    = (int)jsonLevel.getInt("Level_NbMeteors");
	        JSONObject levelSpeed = (JSONObject)jsonLevel.getJSONObject("Level_SpeedMeteor");
	        float levelSpeedMin = (float)levelSpeed.getDouble("min");
	        float levelSpeedMax = (float)levelSpeed.getDouble("max");
	        
	        this.levelNumber = levelNumber;
	        this.space = new Space(this.parent, levelNbMeteors, levelSpeedMin, levelSpeedMax);
	        this.player.setLife(playerLife);
	        this.player.setScore(playerScore);
	        this.player.setSpeed(playerSpeed);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to display level (space and player)
	 * 
	 * @since 1.0
	 */
	public void display(){
		this.player.getModel().display();
		this.player.addToScore((int)Time.getElapsedTimeSec());
		this.space.display();
		this.hud.display(this.player);
	}
	
	/**
	 * Function to display welcome output text in console
	 * 
	 * @param player name
	 * 
	 * @since 1.0
	 */
	public void welcomeToSpaceRocket(String name){
		System.out.println("                                                                                                      ");
		System.out.println("                                       WELCOME TO                                                     ");
		System.out.println(" ____________________________________________________________________________________________________ ");
		System.out.println("                                                                                                      ");
		System.out.println(" _______  _______  _______  _______  _______    ______    _______  _______  ___   _  _______  _______ ");
		System.out.println("|       ||       ||   _   ||       ||       |  |    _ |  |       ||       ||   | | ||       ||       |");
		System.out.println("|  _____||    _  ||  |_|  ||       ||    ___|  |   | ||  |   _   ||       ||   |_| ||    ___||_     _|");
		System.out.println("| |_____ |   |_| ||       ||       ||   |___   |   |_||_ |  | |  ||       ||      _||   |___   |   |  ");
		System.out.println("|_____  ||    ___||       ||      _||    ___|  |    __  ||  |_|  ||      _||     |_ |    ___|  |   |  ");
		System.out.println(" _____| ||   |    |   _   ||     |_ |   |___   |   |  | ||       ||     |_ |    _  ||   |___   |   |  ");
		System.out.println("|_______||___|    |__| |__||_______||_______|  |___|  |_||_______||_______||___| |_||_______|  |___|  ");
		System.out.println("                                                                                                      ");
		System.out.println(" ____________________________________________________________________________________________________ ");
		System.out.println("                                                                                                      ");
		System.out.println("                                        LOADING...                                                    ");
		System.out.println("                                                                                                      ");
		System.out.println("                       Hello " + name + " ! Let's start with level 1 !                                 ");
		System.out.println("                                                                                                      ");
		System.out.println("                                                                                                      ");	
	}
	
	/**
	 * Function to display output text in console when level has changed
	 * 
	 * @param level number
	 * 
	 * @since 1.0
	 */
	public void levelHasChanged(int level){
		System.out.println("                                                                                                      ");
		System.out.println("                              Let's go to start level number " + level + " !                          ");
		System.out.println("                                                                                                      ");
	}
		
	
}
