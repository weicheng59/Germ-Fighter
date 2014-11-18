package model;

import java.io.Serializable;

/**
 * Cell is an Object of germs and white blood cells in the game
 * @author Brandon
 *
 */
public abstract class Cell implements Serializable{
	
	// Variables
	private String cellName; // type of cell
	private int attackPoints;// cell's attack strength
	private int maxHealth;// cell's health; how much damage it can take
	private int health;// cell's actual health; any damage calculated
	private int attackRange;// areas a cell can attack
	private int moveRange;// areas a cell can move
	private int actionPoints;// cell's energy to do stuff
	private int maxActionPoints;
	private int locationX;// cell's x-coordinate location
	private int locationY;// cell's y-coordinate location
	private boolean doublingTruth;// allows picking up Attack Booster item or pass by it
	private Item item;// item of a cell's inventory
	private String icon;// shows what the cell will look like on the textview
	private String[][] gameMap;
	private boolean turn;
	
	public Cell(){
		
	}
	
	public Cell(String cell, int attackPoints, int health, int attackRange, int moveRange, int actionPoints, Item item){
		this.cellName = cell;
		this.attackPoints = attackPoints;
		this.health = health;
		this.attackRange = attackRange;
		this.moveRange = moveRange;
		this.actionPoints = actionPoints;
		this.item = item;
		maxHealth = health;
		maxActionPoints = actionPoints;
		doublingTruth = true;
		turn = false;
	}
	
	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cell) {
		this.cellName = cell;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public int getMaxActionPoints(){
		return maxActionPoints;
	}
	
	public void setMaxActionPoints(int maxActionPoints){
		this.maxActionPoints = maxActionPoints;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public int getMoveRange() {
		return moveRange;
	}

	public void setMoveRange(int moveRange) {
		this.moveRange = moveRange;
	}

	public int getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getLocationX() {
		return locationX;
	}

	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	
	public boolean getDoublingEffectValid(){
		if(doublingTruth == false)
			System.out.println("Already used an Attack Booster item!");
		return doublingTruth;
	}
	
	public void setDoublingEffectValid(boolean doublingTruth) {
		this.doublingTruth = doublingTruth;
	}
	
	// useful method
	public int getDistance(int locationX, int locationY) {
		return Math.abs(getLocationX() - locationX) + Math.abs(getLocationY() - locationY);
	}
	
	// 
	public void endTurn(){
		setActionPoints(0);
	}
	
	public void beginTurn(){
		setActionPoints(maxActionPoints);
	}
	
	

	/**
	 * Subclasses must implement the following methods.
	 * Attack another cell	
	 * return if the attack is sucessfully
	 * 
	 */
	public abstract boolean attack(Cell aCell);
	
	
/*	public void setCanUseAttackBooster(boolean doublingTruth){
		this.doublingTruth = doublingTruth;
	}*/
	
	/*
	 public int getCellLevel(){
	 	return level;
	 }
	 
	 public void setCellLevel(int level){
	 	this.level = level;
	 }
	 
	 public void cellLeveledUp(Cell cell){
	 	cell.setCellLevel(cell.getCellLevel() + 1);
	 }
	 */
	
	
	// "using" methods
	public abstract void useItem(Item item);

	
	/**
	 * return true if unit
	 * return remaining actionPoints
	 * 
	 */
}