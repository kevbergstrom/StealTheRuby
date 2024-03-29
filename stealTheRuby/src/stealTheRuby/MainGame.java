package stealTheRuby;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import jig.Entity;
import jig.ResourceManager;
import stealTheRuby.PlayingState;

public class MainGame extends StateBasedGame {

	public static final int SPLASHSTATE = 0;
	public static final int PLAYINGSTATE = 1;
	public static final int LOADINGSTATE = 2;
	public static final int RESULTSSTATE = 3;
	public static final int GAMEOVERSTATE = 4;
	public static final int WINSTATE = 5;
	
	public static boolean DEBUG = false;
	
	public static final String TESTIMG_RSC = "stealTheRuby/resource/testTile.png";
	public static final String VISIONCONEIMG_RSC = "stealTheRuby/resource/visionCone.png";
	public static final String SECURITYCAMERAIMG_RSC = "stealTheRuby/resource/securityCamera.png";
	public static final String PLAYERSPRITESIMG_RSC = "stealTheRuby/resource/playerSpriteSheet.png";
	public static final String GUARDSPRITESIMG_RSC = "stealTheRuby/resource/guardSpriteSheet.png";
	
	Player player;
	Map map;
	
	public ArrayList<ProjectileImage> collectAnims;
	
	public final int ScreenWidth;
	public final int ScreenHeight;
	public int currentLevel;
	public int score;
	public int totalCoins;
	
	public MainGame(String title, int width, int height) {
		super (title);
		
		ScreenHeight = height;
		ScreenWidth = width;
		
		Entity.setCoarseGrainedCollisionBoundary(Entity.AABB);
		
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new SplashState());
		addState(new PlayingState());
		addState(new LoadingState());
		addState(new ResultsState());
		addState(new GameOverState());
		addState(new WinState());
	
		ResourceManager.loadImage(TESTIMG_RSC);
		ResourceManager.loadImage(VISIONCONEIMG_RSC);
		ResourceManager.loadImage(SECURITYCAMERAIMG_RSC);
		ResourceManager.loadImage(PLAYERSPRITESIMG_RSC);
		ResourceManager.loadImage(GUARDSPRITESIMG_RSC);
		
		Item.loadTextures();
		Trap.loadTextures();
		Levels.loadTextures();
		player = new Player(590,116,32,32);
		map = new Map(25, 16, 32, 32);
		
		collectAnims = new ArrayList<ProjectileImage>();
		currentLevel = 0;
		score = 0;
		totalCoins = 0;
		
	}
	
	public static void main(String[] args) {
	        AppGameContainer app;
	        try {
	            app = new AppGameContainer(new MainGame("Steal The Ruby", 800, 600));
	            app.setDisplayMode(800, 600, false);
	            app.setVSync(true);
	            app.start();
	        } 
	catch
	 (SlickException e) {
	            e.printStackTrace();
	        }
	    }
}