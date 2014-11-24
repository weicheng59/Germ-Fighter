package model;

import java.util.ArrayList;
import java.util.List;

public class WBCBasic extends Cell{
	private Item item2;
	private final int ATTACK_POINTS = 4, HEALTH_POINTS = 10, MAX_HEALTH_POINTS = 10,
					  ATTACK_RANGE = 1, MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	// newborn WBC initial stats
	public WBCBasic(Team team){
		super(team);
		setCellName("Basic WBC");
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
					System.out.println("You killed the enemy Germ!");
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
	public String useItem() {
		if (getItem() == null)
			return "This unit does not have an item.";
		if(getItem().getItemName() == "Attack Booster"){
			setAttackPoints(ATTACK_POINTS*getItem().getBoost());
			setActionPoints(getActionPoints() - 2);
			setItem(null);
			return "Attack Booster used! " + getCellName() 
					+ " now has " + getAttackPoints() + " attack points!";
		}
		else if(getItem().getItemName() == "Health Pack"){
			setHealth(HEALTH_POINTS + getItem().getHealth());
			setActionPoints(getActionPoints() - 2);
			setItem(null);
			return "Still working on that...";
		}
		else{
	//		set the bomb damage and also use that as an all around attack
			return "Still working on that...";
		}
	
	}

	public Item getItem2() {
		return item2;
	}

	public void setItem2(Item item) {
		this.item2 = item;
	}
	
	
}