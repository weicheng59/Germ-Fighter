package model;

import java.util.ArrayList;
import java.util.List;

public class GermRanged extends Cell{
	private List<Item> items;
	private final int ATTACK_POINTS = 4, HEALTH_POINTS = 8, MAX_HEALTH_POINTS = 8, ATTACK_RANGE = 3, 
					  MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	// newborn Germ initial stats
	public GermRanged(){
		setCellName("Ranged");
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

	/**
	 * TODO: damege decrease
	 * 4 2 1
	 */
	@Override
	public boolean attack(Cell aCell) {
		int distance = Math.abs(getLocationX() - aCell.getLocationX()) + 
						Math.abs(getLocationY() - aCell.getLocationY());
		int damage = 4;
		if(getActionPoints() >= 2) {
			if(distance <= getAttackRange()) {
				if (distance == 3 & aCell.getHealth() > 3){
					damage = 1;
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + damage + " damage to the objective!");
				}
				else if (distance == 2 & aCell.getHealth() > 2){
					damage = 2;
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + damage + " damage to the objective!");
				}
				else if (distance == 1 & aCell.getHealth() > 4){
					damage = 4;
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + damage + " damage to the objective!");
				}
				else if(aCell.getHealth() > damage) {
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + ATTACK_POINTS + " damage to the objective!");
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