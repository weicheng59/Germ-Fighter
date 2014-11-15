package model;

import java.io.Serializable;

public abstract class Item implements Serializable {
	private String itemName;
	private int boost;
	private int experience;
	private int damage;
	private int locationX;
	private int locationY;
	
	public Item(){
		boost = 1;
	}
	
	// get item values	
	public String getItemName(){
		return itemName;
	}
	
	public int getBoost() {
		return boost;
	}

	public int getHealth() {
		return experience;
	}

	public int getDamage() {
		return damage;
	}
	
	public int getLocationX(){
		return locationX;
	}
	
	public int getLocationY(){
		return locationY;
	}
	
	// set item values
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	
	public void setBoost(int boost) {
		this.boost = boost;
	}

	public void setHealth(int health) {
		this.experience = health;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setLocationX(int locationX){
		this.locationX = locationX;
	}
	
	public void setLocationY(int locationY){
		this.locationY = locationY;
	}
}
