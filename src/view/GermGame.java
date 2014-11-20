package view;
import java.util.Observable;

import model.GermBasic;


public class GermGame extends Observable 
{
	private GameMap map;
	private GermBasic whiteCell;
	private GermBasic germ;
	private int size;
	private boolean gameOver;
	
	public GermGame ( GameMap map, int whiteX, int whiteY, int germX, int germY)
	{
		this.map = map;
		whiteCell  = new GermBasic();
		whiteCell.setLocationX(whiteX);
		whiteCell.setLocationY(whiteY);
		germ = new GermBasic();
		germ.setLocationX(germX);
		germ.setLocationY(germY);
		gameOver = false;
	}
	public GermGame ( int size, int whiteX, int whiteY, int germX, int germY)
	{
		map = new GameMap(size,size);
		whiteCell  = new GermBasic();
		whiteCell.setLocationX(whiteX);
		whiteCell.setLocationY(whiteY);
		germ = new GermBasic();
		germ.setLocationX(germX);
		germ.setLocationY(germY);
		gameOver = false;
	}
	public void setCellLocation(Cell cell, int x, int y)
	{
		cell.setLocationX(x);
		cell.setLocationY(y);
	}
	public int getCellX(Cell cell)
	{
		return cell.getLocationX();
	}
	public int getCellY(Cell cell)
	{
		return cell.getLocationY();
	}
	//public void moveCell(Cell cell, int x, int y)
	public boolean gameOver()
	{
		return gameOver;
	}
	public GameMap getMap()
	{
		return map;
	}
}
