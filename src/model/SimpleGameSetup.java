package model;

import java.util.Observable;

public class SimpleGameSetup  extends Observable{
	
	private Room[][] gameMap;
	private Cell germ, wbc;
	private int germX = 0;
	private int germY = 0;
	private int wbcX = 0;
	private int wbcY = 0;
	private int itemX = 0;
	private int itemY = 0;
	private boolean gameOver = false;
	private String prompt = "";
	
	public SimpleGameSetup(int mapSize){
		germ = new GermBasic();
	//	wbc = new WBCBasic();
		gameMap = new Room[mapSize][mapSize];
		
		for(int i = 0; i < mapSize; i++){
			for(int j = 0; j < mapSize; j++){
				gameMap[i][j] = new Room();
			}
		}
		
		SpawnGerm(mapSize);
		SpawnWBC(mapSize);
		SpawnItem(mapSize);
		setEmpty(mapSize);
		prompt = "Germ-Fighter! A Sick Game to Play!";
	}
	
	public Room getRoom(int x, int y){
		return gameMap[x][y];
	}

	private void SpawnGerm(int mapSize) {
		germX = 0;
		germY = 0;
		
		gameMap[germX][germY].setGerm(true);
		gameMap[germX][germY].setEmpty(false);
	}
	
	private void SpawnItem(int mapSize){
		itemX = 2;
		itemY = 2;
		
		gameMap[itemX][itemY].setItem(true);
		gameMap[itemX][itemY].setEmpty(false);
	}
	
	private void SpawnWBC(int mapSize) {
		wbcX = mapSize-1;
		wbcY = mapSize-1;
		
		gameMap[wbcX][wbcY].setWbc(true);
		gameMap[wbcX][wbcY].setEmpty(false);
	}
	
	private void setEmpty(int mapSize) {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++){
				if (!gameMap[i][j].isGerm() && !gameMap[i][j].isItem()
						&& !gameMap[i][j].isMapObject() && !gameMap[i][j].isWbc())
					gameMap[i][j].setEmpty(true);
			}
		}
	}
	
	public void whoseTurn(){
		// whether action points are zero or the player ends turn
		
		// 1.) when the end turn button is pressed
		
		// 2.) when a cell faction runs out of action points
		if(wbc.getActionPoints() == 0){
			germ.setActionPoints(germ.getMaxActionPoints());
		}
		if(germ.getActionPoints() == 0){
			wbc.setActionPoints(wbc.getMaxActionPoints());
		}
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
			if(gameMap[y-1][x].isItem()) {
				aCell.setItem(gameMap[y-1][x].getItem());
				gameMap[y-1][x].setItem(false);
			}
			
			gameMap[y][x].setGerm(false);
			gameMap[y-1][x].setGerm(true);
			
			// change the location information stored in cell			
			aCell.setLocationY(y-1);
			
		} else if(direction == MoveDirection.Down) {
			
			// return false if the room is not enterable
			if(y == gameMap.length || gameMap[y+1][x].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y+1][x].isItem()) {
				aCell.setItem(gameMap[y+1][x].getItem());
				gameMap[y+1][x].setItem(false);
			}
			
			gameMap[y][x].setGerm(false);
			gameMap[y+1][x].setGerm(true);
			
			// change the location information stored in cell			
			aCell.setLocationY(y+1);
			
		} else if (direction == MoveDirection.Left) {
			// return false if the room is not enterable
			if(x == 0 || gameMap[y][x-1].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y][x-1].isItem()) {
				aCell.setItem(gameMap[y][x-1].getItem());
				gameMap[y][x-1].setItem(false);
			}
			
			gameMap[y][x].setGerm(false);
			gameMap[y][x-1].setGerm(true);
			
			// change the location information stored in cell			
			aCell.setLocationX(x-1);
		} else {
			// return false if the room is not enterable
			if(x == gameMap[0].length || gameMap[y][x+1].isFull())
				return false;
			
			// pick up the item if there is one
			if(gameMap[y][x+1].isItem()) {
				aCell.setItem(gameMap[y][x+1].getItem());
				gameMap[y][x+1].setItem(false);

			}
			
			gameMap[y][x].setGerm(false);
			gameMap[y][x+1].setGerm(true);
			
			// change the location information stored in cell			
			aCell.setLocationX(x+1);
			
		}
		return true;
	}
}
