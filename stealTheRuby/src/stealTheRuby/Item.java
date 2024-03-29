package stealTheRuby;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

public class Item extends Entity{
	
	public static final String COINIMG_RSC = "stealTheRuby/resource/coin.png";
	public static final String SMALLRUBYIMG_RSC = "stealTheRuby/resource/smallRuby.png";
	public static final String KEYIMG_RSC = "stealTheRuby/resource/key.png";
	public static final String LOCKIMG_RSC = "stealTheRuby/resource/lock.png";
	public static final String BIKEIMG_RSC = "stealTheRuby/resource/testBike.png";
	public static final String STOPWATCHIMG_RSC = "stealTheRuby/resource/stopWatch.png";
	public static final String JAMMERIMG_RSC = "stealTheRuby/resource/electronicsJammer.png";
	
	public static void loadTextures() {
		
		ResourceManager.loadImage(COINIMG_RSC);
		ResourceManager.loadImage(SMALLRUBYIMG_RSC);
		ResourceManager.loadImage(KEYIMG_RSC);
		ResourceManager.loadImage(LOCKIMG_RSC);
		ResourceManager.loadImage(BIKEIMG_RSC);
		ResourceManager.loadImage(STOPWATCHIMG_RSC);
		ResourceManager.loadImage(JAMMERIMG_RSC);
		
	}
	
	private boolean solid;
	private Image image;
	private String tex;
	private String name;
	
	public Item(float x, float y, boolean sol) {
		super(x,y);
		solid = sol;
		tex = null;
		name = "";
	}
	
	public void pickup(StateBasedGame game) {
		//meant to be overridden
	}
	
	public void use(StateBasedGame game) {
		//meant to be overridden
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void setImage(String texture, int sizeX,int sizeY) {
		Image newImage = ResourceManager.getImage(texture).getScaledCopy(sizeX, sizeY);
		newImage.setFilter(Image.FILTER_NEAREST);
		addImageWithBoundingBox(newImage);
		image = newImage;
		tex = texture;
	}
	
	public void setImageWithColor(String texture, int sizeX,int sizeY, Color col) {
		
		Image newImage = ResourceManager.getImage(texture).getScaledCopy(sizeX, sizeY);
		newImage.setFilter(Image.FILTER_NEAREST);
		newImage.setImageColor(col.r, col.g, col.b);
		addImageWithBoundingBox(newImage);
		image = newImage;
		tex = texture;
		
	}
	
	public String getTexture() {
		return tex;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void removeThis(StateBasedGame game) {
		MainGame mg = (MainGame)game;
		Vector gridPos = mg.map.getGridPos(this.getX(), this.getY());
		mg.map.removeItem((int)gridPos.getX(), (int)gridPos.getY());
	}
	
	public void addToInventory(StateBasedGame game) {
		MainGame mg = (MainGame)game;
		mg.player.addItem(this);
	}
	
	public boolean getSolid() {
		return solid;
	}
	
	public void setSolid(boolean sol) {
		solid = sol;
	}
	
	public boolean unlock(Color c, StateBasedGame game) {
		return false;
	}
	
	public void addCollectAnim(float startX, float startY, float endX, float endY, int type, StateBasedGame game) {
		MainGame mg = (MainGame)game;
		ProjectileImage newPI = new ProjectileImage(getX(), getY(), startX, startY, endX, endY, type, this);
		mg.collectAnims.add(newPI);
	}
	
}
