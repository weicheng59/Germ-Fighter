package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DestructableWallSprite extends Sprite {
	
	private static BufferedImage sheet;
	private static int width = 0;//TODO <<< get these later!
	private static int height = 0;//TODO <<< get these later!
	private static int MAX_FRAMES = 15;//TODO magic number?
	private boolean isDead;
	
	
	public DestructableWallSprite(){
		super();
		
		if(sheet == null){
			try{//TODO
				sheet = ImageIO.read(new File("INSERT FILE HERE"));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		isDead = false;
	}
	

	@Override
	public Image getImage() {
		// TODO
		if(frame < MAX_FRAMES){
			int row = frame / 1;// TODO
			int col = frame % 1;// TODO
			
			BufferedImage frameImg = sheet.getSubimage(col*width, row*height, width, height);
			
			frame++;
			return frameImg;
		}
		else{
			isDead = true;
			return null;
		}
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
}
