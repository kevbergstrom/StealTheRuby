package stealTheRuby;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LoadingState extends BasicGameState{

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		
	}
	
	public void clearLevel(StateBasedGame game) {
		
	}
	
	public void loadLevel(StateBasedGame game) {
		MainGame mg = (MainGame)game;
		clearLevel(game);
		mg.currentLevel = mg.currentLevel+1;
		Levels.loadLevel(mg.currentLevel, game);
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		MainGame mg = (MainGame)game;
		loadLevel(game);
		mg.player.reset();
		mg.enterState(MainGame.PLAYINGSTATE);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}

	@Override
	public int getID() {
		return MainGame.LOADINGSTATE;
	}

}
