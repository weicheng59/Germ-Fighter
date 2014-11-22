package model;

import java.util.ArrayList;
import java.util.Random;

import model.Cell.Team;

/**
 * This class stores turn information and Cell list
 * 
 * @author Weicheng Yu
 *
 */
public class Player {
	private ArrayList<Cell> crew;
	private boolean goFirst, turnEnd;
	private int playerNum; // Used for text output
	private Team team;

	public Player(Team team, int playerNum) {
		crew = new ArrayList<Cell>();
		this.setTeam(team);
		this.playerNum = playerNum;
		goFirst = false;
		turnEnd = false;
	}
	
	public int Roll(int bound) {
		Random rand = new Random();
		return rand.nextInt(bound);
	}
	
	// This method add Cell to the crew
	// This method should be called when choose crew
	public void addCell(Cell aCell) {
		crew.add(aCell);
	}
	
	public void removeCell(Cell aCell) {
		crew.remove(aCell);
	}
	
	// This method is used to let player choose crewMember to control
	public void printCrew() {
		for (int i = 0; i < crew.size(); i++) {
			System.out.println(i+1 + ". " +crew.get(i).getCellName());
		}
	}
	
	// Set all member of the crew to maxActionPoints
	// this method should be called at every start of the turn
	public void newTurn() {
		turnEnd = false;
		for (int i = 0; i < crew.size(); i++)
			crew.get(i).setActionPointsToMax();
	}
	
	// Set actionPoints of all member of the crew to 0
	// this method should be called at every end of the turn
	public void endTurn() {
		turnEnd = true;
		for (int i = 0; i < crew.size(); i++)
			crew.get(i).setActionPoints(0);
	}
	
	// The player is lost if he/she lost all his crewMember
	public boolean isLost() {
		for (int i = 0; i < crew.size(); i++)
			if (crew.get(i) != null)
				return false;
		return true;
	}
	
	// getters and setters
	public boolean goFirst() {
		return goFirst;
	}
	
	public void setGoFirst(boolean goFirst) {
		this.goFirst = goFirst;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	public ArrayList<Cell> getCrew() {
		return crew;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public boolean turnEnd() {
		return turnEnd;
	}
}
