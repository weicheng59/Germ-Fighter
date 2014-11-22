package model;

import model.Cell.Team;

public class Room {
	private boolean hasMapObject;
	
	// use item and cell object to store them in room instead of boolean
	private Item item;
	private Cell cell;
	
	public Room() {
		item = null;
		cell = null;
		hasMapObject = false;
	}
	
	public boolean hasCell() {
		return cell != null;
	}

	public boolean hasItem() {
		return item != null;
	}

	public boolean hasMapObject() {
		return hasMapObject;
	}

	public void setMapobject(boolean mapobject) {
		this.hasMapObject = mapobject;
	}

	public boolean isEmpty() {
		return !hasCell()  && !hasItem() && !hasMapObject;
	}
	
	// set the actual item to this room
	public void setItem(Item item){
		this.item = item;
	}
	
	/**
	 * This method is used to pick up item
	 * @return the Item in this room
	 */
	public Item removeItem() {
		Item toReturn = item;
		item = null;
		return toReturn;
	}
	
	// return the item in this room
	public Item getItem() {
		return item;
	}
	
	public void setCell(Cell aCell) {
		cell = aCell;
	}

	public Cell getCell() {
		return cell;
	}

	public String toString(){
		if(hasCell())
			if(cell.getTeam() == Team.GERM)
				return "[G]";
			else
				return "[V]";
		else if(hasItem())
			return "[I]";
		else if(hasMapObject)
			return "[O]";
		else
			return "[ ]";
	}
	
	/**
	 * This method return ture is the room is not enterable
	 * @return
	 */
	public boolean isFull(){
		if(hasMapObject || hasCell())
			return true;
		else
			return false;
	}
}