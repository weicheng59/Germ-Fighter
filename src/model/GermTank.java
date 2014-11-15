package model;

import java.util.ArrayList;
import java.util.List;

public class GermTank extends Cell{
	private List<Item> items;
	private final int ATTACK_POINTS = 3, HEALTH_POINTS = 15, MAX_HEALTH_POINTS = 10, ATTACK_RANGE = 1, 
					  MOVE_RANGE = 4, ACTION_POINTS = 4;
	
	// newborn WBC initial stats
	public GermTank(){
		setCell("Tank");
		setAttackPoints(ATTACK_POINTS);
		setHealth(HEALTH_POINTS);
		setMaxHealth(MAX_HEALTH_POINTS);
		setAttackRange(ATTACK_RANGE);
		setMoveRange(MOVE_RANGE);
		setActionPoints(ACTION_POINTS);
		setDoublingEffectValid(true);
		setIcon("[G]");
		items = new ArrayList<Item>();
	}

	@Override
	public boolean attack(Cell aCell) {
		// TODO Auto-generated method stub
		if(getActionPoints() >= 2) {
			if(Math.abs(getLocationX() - aCell.getLocationX()) + 
			   Math.abs(getLocationY() - aCell.getLocationY()) <= getAttackRange()) {
				if(aCell.getHealth() > getAttackPoints()) {
					aCell.setHealth(aCell.getHealth() - getAttackPoints());
					System.out.println("You deal " + ATTACK_POINTS + " damages to the objective!");
				} else {
					aCell.setHealth(0);
					System.out.println("You killed the objective!");
				}
				setActionPoints(0);
				return true;
			} else {
				System.out.println("The objective is out of attack range.");
				return false;
			}
		} else
			System.out.println("This unit does not have enough action points to do so.");
			return false;
	}

	@Override
	public boolean move(int locationX, int locationY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void useItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean addItem(Item item) {
		if (items.size() < 1) {
			items.add(item);
			return true;
		} else
			return false;
	}
	
}