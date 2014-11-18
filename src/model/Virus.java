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
	
	public Virus(){
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

	@Override
	public boolean attack(Cell aCell) {
		// viruses attack like basic cell units
		return false;
	}

	@Override
	public void useItem(Item item) {
		// Viruses do not use items!
		
	}
}
