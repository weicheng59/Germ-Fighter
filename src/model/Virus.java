package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Surprise! After 5 turns, Virus units will appear. They will attack both germ and wbcs so they are considered a neutral faction.  You can gain experience from them so leveling up is better but they attack in groups.
 * 
 * @author Brandon
 *
 */
public class Virus extends Cell{
	private final int ATTACK_POINTS = 4, HEALTH_POINTS = 10, MAX_HEALTH_POINTS = 10, ATTACK_RANGE = 1, 
					  MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	public Virus(Team team){
		super(team);
		setCellName("Virus");
		setAttackPoints(ATTACK_POINTS);
		setHealth(HEALTH_POINTS);
		setMaxHealth(MAX_HEALTH_POINTS);
		setAttackRange(ATTACK_RANGE);
		setMoveRange(MOVE_RANGE);
		setActionPoints(ACTION_POINTS);
		setDoublingEffectValid(false);
		setIcon("[V]");
	}

	public int attack(Cell aCell) {
		if(getActionPoints() >= 2) {
			if(Math.abs(getLocationX() - aCell.getLocationX()) + 
			   Math.abs(getLocationY() - aCell.getLocationY()) <= getAttackRange()) {
				setActionPoints(0);
				if(aCell.getHealth() > getAttackPoints()) {
					aCell.setHealth(aCell.getHealth() - getAttackPoints());
					return 2;
				} else {
					aCell.setHealth(0);
					System.out.println("You killed the enemy Cell!");
					return 3;
				}
			} else {
				System.out.println("The objective is out of attack range.");
				return 1;
			}
		} else {
			System.out.println("This unit does not have enough action points to do so.");
			return 0;
		}
	}

	
	public void useItem(Item item) {
		// Viruses do not use items!		
	}

	@Override
	public String useItem() {
		// TODO Auto-generated method stub
		return null;
	}
}
