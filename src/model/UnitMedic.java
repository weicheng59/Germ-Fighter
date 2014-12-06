package model;

public class UnitMedic extends Cell{

	private final int ATTACK_POINTS = 4, HEALTH_POINTS = 10, MAX_HEALTH_POINTS = 10, ATTACK_RANGE = 1, 
					  MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	// newborn Germ initial stats
	public UnitMedic(Team team){
		super(team);
		if (team == Team.GERM)
			setCellName("Medic Germ");
		else
			setCellName("Medic White Blood Cell");
		setAttackPoints(ATTACK_POINTS);
		setHealth(HEALTH_POINTS);
		setMaxHealth(MAX_HEALTH_POINTS);
		setAttackRange(ATTACK_RANGE);
		setMoveRange(MOVE_RANGE);
		setMaxActionPoints(ACTION_POINTS);
		setActionPoints(0);
		setDoublingEffectValid(true);

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
					System.out.println("You killed the enemy!");
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
	/*
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
*/
	/**
	 * Heals a friendly unit by 3 health points.
	 * @param aCell The friendly unit that is being healed by the medic unit.
	 */
	public void healCell(Cell aCell){
		aCell.setHealth(aCell.getHealth() + 3);
	}


	@Override
	public String useItem() {
		return null;		
	}
	
}