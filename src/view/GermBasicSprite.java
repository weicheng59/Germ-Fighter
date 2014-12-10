package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Thread.State;

import javax.imageio.ImageIO;

public class GermBasicSprite extends Sprite
{
	private static final int leftBorder = 3, vertBorder = 4; // magic numbers for the sheet
	private static final int MAX_FRAMES = 7; // more magic numbers
	private static final int width = 35, height = 35; // width and height of a single frame
	
	private static BufferedImage sheet; // the sprite sheet
	private State previousState; // the last state of the frog
	
	public GermBasicSprite()
	{
		if(sheet == null)
		{
			try
			{
				sheet = ImageIO.read(new File("images/Basic Germ Sprite.png"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		previousState = State.IDLE;
	}
	
	public void setState(State state)
	{
		previousState = getState();
		super.setState(state);
	}
	
	@Override
	public Image getImage()
	{
		if(sheet == null)
		{
			return null;
		}
		int row = 0, col = frame, offset = 3;
		
		switch(getState())
		{
		case IDLE:
			row = 1;
			break;
		case MOVING:
			row = 0;
			break;
		default:
			break;
		}
		frame = (frame + 1) % MAX_FRAMES;
		BufferedImage temp = sheet.getSubimage(leftBorder + col * width, row * (height + vertBorder), width - offset, height);
		return temp;//.getScaledInstance(2*width, 2*height, Image.SCALE_DEFAULT);
	}

	@Override
	public int getWidth() 
	{
		// TODO Auto-generated method stub
		return 2*width;
	}

	@Override
	public int getHeight() 
	{
		// TODO Auto-generated method stub
		return 2*height;
	}
	
}
