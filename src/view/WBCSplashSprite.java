package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Thread.State;

import javax.imageio.ImageIO;

public class WBCSplashSprite extends Sprite{
	private static final int LeftBorder = 3; // TODO
	private static final int VertBorder = 4; // TODO
	private static final int MAX_FRAMES = 7; // TODO
	private static final int width = 35; // TODO
	private static final int height = 35; // TODO
	
	private static BufferedImage sheet;
	private State previousState;
	
	public WBCSplashSprite(){
		if(sheet == null)
			try{
				sheet = ImageIO.read(new File("images/Bomb Cell Sprite"));
			}
			catch(Exception e){};
		previousState = State.IDLE;
	}
	
	@Override
	public void setState(State state){
		previousState = getState();
		super.setState(state);
	}

	@Override
	public Image getImage() {
		if(sheet == null)
			return null;
		
		int row = 0;
		int col = frame;
		int offset = 3;
		
		switch(getState()){
			case IDLE:
				row = 1;
			case MOVING: 
				row = 0; //TODO
				break;
			default:
				break;
		}
		
		// TODO : hard code, trial and error
		frame = (frame + 1) % MAX_FRAMES;
		
		BufferedImage temp = sheet.getSubimage(LeftBorder + col * width, row * (height + VertBorder), width - offset, height);
		
		return temp;
	}

	@Override
	public int getWidth() {
		// TODO
		return width;
	}

	@Override
	public int getHeight() {
		// TODO
		return height;
	}
}
