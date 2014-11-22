package model;

import java.util.Observable;

import model.Cell.Team;

public class GermFighter  extends Observable{
	
	private Room[][] gameMap;
	private String prompt = "";
	
	public GermFighter(int mapSize){
		gameMap = new Room[mapSize][mapSize];
		
		// Intial the map with empty room
		for(int i = 0; i < mapSize; i++){
			for(int j = 0; j < mapSize; j++){
				gameMap[i][j] = new Room();
			}
		}

		prompt = "Germ-Fighter! A Sick Game to Play!";
	}
	
	public Room getRoom(int x, int y){
		return gameMap[x][y];
	}
	
	public Room[][] getMap(){
		return gameMap;
	}
	
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public String getPromot() {
		return prompt;
	}

	// preset the Germ to the left corner of the gameMap
	public void SpawnCell(Cell aCell) {
		if(aCell.getTeam() == Team.GERM) {
			aCell.setLocationX(0);
			aCell.setLocationY(0);
		} else {
			aCell.setLocationX(getMap().length-1);
			aCell.setLocationY(getMap().length-1);
		}
		
		gameMap[aCell.getLocationY()][aCell.getLocationX()].setCell(aCell);
	}
	
	public void SpawnItem(Item aItem){
		aItem.setLocationX(getMap().length/2);
		aItem.setLocationY(getMap().length/2);
				
		gameMap[aItem.getLocationY()][aItem.getLocationX()].setItem(aItem);
	}
	
	public boolean move(Cell aCell, MoveDirection direction) {
		
		// return false if the cell dont have enough actionPoint
		if (aCell.getActionPoints() < 1) {
			System.out.println("This unit does not have enough action point to move");
			return false;
		}
		
		int x = aCell.getLocationX(), y = aCell.getLocationY();
		
		if (direction == MoveDirection.Up) {
			
			// return false if the room is not enterable
			if(y == 0 || gameMap[y-1][x].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y-1][x].hasItem())
				aCell.setItem(gameMap[y-1][x].removeItem());
			
			gameMap[y][x].setCell(null);
			gameMap[y-1][x].setCell(aCell);
			
			// change the location information stored in cell			
			aCell.setLocationY(y-1);
		} else if(direction == MoveDirection.Down) {
			
			// return false if the room is not enterable
			if(y == gameMap.length || gameMap[y+1][x].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y+1][x].hasItem())
				aCell.setItem(gameMap[y+1][x].removeItem());
			
			gameMap[y][x].setCell(null);
			gameMap[y+1][x].setCell(aCell);
			
			// change the location information stored in cell			
			aCell.setLocationY(y+1);
			
		} else if (direction == MoveDirection.Left) {
			// return false if the room is not enterable
			if(x == 0 || gameMap[y][x-1].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y][x-1].hasItem())
				aCell.setItem(gameMap[y][x-1].removeItem());
			
			gameMap[y][x].setCell(null);
			gameMap[y][x-1].setCell(aCell);
			
			// change the location information stored in cell			
			aCell.setLocationX(x-1);
		} else {
			// return false if the room is not enterable
			if(x == gameMap[0].length || gameMap[y][x+1].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y][x+1].hasItem())
				aCell.setItem(gameMap[y][x+1].removeItem());
			
			gameMap[y][x].setCell(null);
			gameMap[y][x+1].setCell(aCell);
			
			// change the location information stored in cell			
			aCell.setLocationX(x+1);
		}
		aCell.setActionPoints(aCell.getActionPoints()-1);
		return true;
	}
	

	
	/**
	 * This method prints the current gameMap in console
	 */
	public void printMap(int mapSize) {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++)
				System.out.print(gameMap[i][j].toString() + " ");
			System.out.println("\n ");
		}
	}
	
	public void printPrompt() {
		System.out.println(prompt);
	}
	
	public void printInvalidInput() {
		System.out.println("Invailed input! Please try again");
	}
}
