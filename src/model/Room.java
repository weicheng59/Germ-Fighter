package model;

public class Room {
	private boolean hasGerm, hasWbc, hasItem, hasMapObject, empty;
	private Item item;
	
	public Room() {
		hasGerm = false;
		hasWbc = false;
		hasItem = false;
		hasMapObject = false;
		empty = false;
	}
	
	
	public boolean isGerm() {
		return hasGerm;
	}


	public void setGerm(boolean germ) {
		this.hasGerm = germ;
	}


	public boolean isWbc() {
		return hasWbc;
	}


	public void setWbc(boolean wbc) {
		this.hasWbc = wbc;
	}


	public boolean isItem() {
		return hasItem;
	}


	public void setItem(boolean item) {
		this.hasItem = item;
	}


	public boolean isMapObject() {
		return hasMapObject;
	}


	public void setMapobject(boolean mapobject) {
		this.hasMapObject = mapobject;
	}


	public boolean isEmpty() {
		return empty;
	}


	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
	public void setItem(Item item){
		this.item = item;
	}
	
	// return the item in this room
	public Item getItem() {
		return item;
	}


	public String toString(){
		if(hasGerm == true)
			return "[G]";
		if(hasWbc == true)
			return "[W]";
		if(hasItem == true && (hasGerm == false || hasWbc == false))
			return "[I]";
		if(hasMapObject == true && (hasGerm == false || hasWbc == false))
			return "[O]";
		else{
			return "[ ]";
		}
	}
	
	/**
	 * This method return ture is the room is not enterable
	 * @return
	 */
	public boolean isFull(){
		if(hasMapObject || hasGerm || hasWbc)
			return true;
		else
			return false;
	}
}