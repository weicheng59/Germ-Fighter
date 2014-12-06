package model;

public class UnitRanged extends Cell{

	private final int ATTACK_POINTS = 4, HEALTH_POINTS = 8, MAX_HEALTH_POINTS = 8, ATTACK_RANGE = 3, 
					  MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	// newborn Germ initial stats
	public UnitRanged(Team team){
		super(team);
		if (team == Team.GERM)
			setCellName("Ranged Germ");
		else
			setCellName("Ranged White Blood Cell");
		setAttackPoints(ATTACK_POINTS);
		setHealth(HEALTH_POINTS);
		setMaxHealth(MAX_HEALTH_POINTS);
		setAttackRange(ATTACK_RANGE);
		setMoveRange(MOVE_RANGE);
		setMaxActionPoints(ACTION_POINTS);
		setActionPoints(0);
		setDoublingEffectValid(true);
	}

/*	public int attack(Cell aCell) {
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
	}*/
	
	/**
	 * TODO: damege decrease
	 * 4 2 1
	 */
	@Override
	public int attack(Cell aCell) {
		int distance = Math.abs(this.getLocationX() - aCell.getLocationX()) + 
						Math.abs(this.getLocationY() - aCell.getLocationY());
		int damage = 0;
		if(getActionPoints() >= 2) {
			if(distance <= getAttackRange()) {
				if (distance == 3 & aCell.getHealth() > 3){
					damage = ATTACK_POINTS/ATTACK_POINTS;
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + damage + " damage to the objective!");
				}
				else if (distance == 2 & aCell.getHealth() > 2){
					damage = ATTACK_POINTS/2;
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + damage + " damage to the objective!");
				}
				else if (distance == 1 & aCell.getHealth() > 4){
					damage = ATTACK_POINTS;
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + damage + " damage to the objective!");
				}
				else if(aCell.getHealth() > damage) {
					aCell.setHealth(aCell.getHealth() - damage);
					System.out.println("You deal " + ATTACK_POINTS + " damage to the objective!");
				} else {
					aCell.setHealth(0);
					System.out.println("You killed the enemy!");
				}
				setActionPoints(0);
				return damage;
			} else {
				System.out.println("The objective is out of attack range.");
				return damage;
			}
		} else
			System.out.println("This unit does not have enough action points to do so.");
			return damage;
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
	
}