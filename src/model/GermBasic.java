package model;

import java.util.ArrayList;
import java.util.List;

public class GermBasic extends Cell{
	private Item item2;
	private final int ATTACK_POINTS = 4, HEALTH_POINTS = 10, MAX_HEALTH_POINTS = 10,
					  ATTACK_RANGE = 1, MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	// newborn Germ initial stats
	public GermBasic(Team team){
		super(team);
		setCellName("Basic Germ");
		setAttackPoints(ATTACK_POINTS);
		setHealth(HEALTH_POINTS);
		setMaxHealth(MAX_HEALTH_POINTS);
		setAttackRange(ATTACK_RANGE);
		setMoveRange(MOVE_RANGE);
		setMaxActionPoints(ACTION_POINTS);
		setActionPoints(0);
		setDoublingEffectValid(true);
	}

	@Override
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
					System.out.println("You killed the objective!");
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
	 
	
	@Override
	public void useItem(Item item) {
		if(item.getItemName() == "Attack Booster"){
			setAttackPoints(ATTACK_POINTS*item.getBoost());
		}
		else if(item.getItemName() == "Health Pack"){
			setHealth(HEALTH_POINTS + item.getHealth());
		}
		else{
	//		set the bomb damage and also use that as an all around attack
		}
	
	}

	public Item getItem2() {
		return item2;
	}

	public void setItem2(Item item) {
		this.item2 = item;
	}
	
	
}