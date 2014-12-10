package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.Sprite;

public class SpriteObject {
	public Point position;
	private Sprite sprite;
	private Image frame;
	private Timer t;
	
	/**
	 * 
	 * @param sprite
	 * @param x
	 * @param y
	 * @param delay
	 */
	protected SpriteObject(Sprite sprite, int x, int y, int delay){
		this.sprite = sprite;
		this.position = new Point(x, y);
		frame = sprite.getImage();
		
		t = new Timer(delay, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nextFrame();
			}
		});
	}
	
	/**
	 * 
	 * @return
	 */
	public Sprite getSprite(){
		return sprite;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y){
		position.setLocation(x, y);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void draw(Graphics g){
		if (sprite != null && !sprite.isFinished()) // only render if not finished
			g.drawImage(frame, position.x  - sprite.getWidth()/2, position.y - sprite.getHeight()/2, null);
	}
	
	/**
	 * The cell is moving (doesn't matter what direction; universal)
	 */
	public void move(){
		if(sprite.getState() != Sprite.State.MOVING){
			sprite.setState(Sprite.State.MOVING);
			nextFrame();
		}
		
		position.translate(0, 0); // TODO
	}
	
	/**
	 * Stop moving the SpriteObject
	 */
	public void moveStop(){
		if(sprite.getState() != Sprite.State.IDLE){
			sprite.setState(Sprite.State.IDLE);
			nextFrame();
		}
	}
	
	/**
	 * Start animating the SpriteObject
	 */
	public void start(){
		if(!t.isRunning()){
			t.start();
		sprite.reset();
		}
	}
	
	/**
	 * Stop animating the sprite
	 */
	public void stop(){
		t.stop();
	}
	
	/**
	 * Advance the frame to the next image
	 */
	private void nextFrame(){
		frame = sprite.getImage();
	}
}
