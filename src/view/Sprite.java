package view;
import java.awt.Image;

public abstract class Sprite {
	
	public static enum State{
		IDLE, MOVING, ATTACKING
	};
	
	protected State state;
	protected int frame;
	
	public Sprite(){
		state = State.IDLE;
		frame = 0;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public State getState(){
		return state;
	}
	
	public boolean isFinished(){
		return false;
	}
	
	public void reset(){}
	
	public abstract Image getImage();
	
	public abstract int getWidth();
	
	public abstract int getHeight();
	
}
