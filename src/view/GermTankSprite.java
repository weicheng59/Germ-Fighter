package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Thread.State;

import javax.imageio.ImageIO;

public class GermTankSprite extends Sprite{
	private static final int LeftBorder = 1; // TODO
	private static final int VertBorder = 1; // TODO
	private static final int MAX_FRAMES = 1; // TODO
	private static final int width = 1; // TODO
	private static final int height = 1; // TODO
	
	private static BufferedImage sheet;
	private State previousState;
	
	public GermTankSprite(){
		if(sheet == null)
			try{
				sheet = ImageIO.read(new File("GERM TANK HERE"));
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
				col = 0;
				switch(previousState){
				case MOVING: row = 2;// TODO
					break;
				default:
					break;
				}
			case MOVING: row = 3; //TODO
				break;
			default:
				break;
		}
		
		// TODO : hard code, trial and error
		frame = (frame + 1) % MAX_FRAMES;
		
		BufferedImage temp = sheet.getSubimage(LeftBorder + col * width, row * (height + VertBorder), width - offset, height);
		
		return temp.getScaledInstance(2*width, 2*height, Image.SCALE_DEFAULT);
	}

	@Override
	public int getWidth() {
		// TODO
		return 2 * width;
	}

	@Override
	public int getHeight() {
		// TODO
		return 2 * height;
	}
}
