package model;

public class UnitSplashAttacker extends Cell{
	private final int ATTACK_POINTS = 3, HEALTH_POINTS = 8, MAX_HEALTH_POINTS = 8, ATTACK_RANGE = 1, 
					  MOVE_RANGE = 5, ACTION_POINTS = 5;
	
	// newborn Germ initial stats
	public UnitSplashAttacker(Team team){
		super(team);
		if (team == Team.GERM)
			setCellName("Splash Attacking Germ");
		else
			setCellName("Splash Attacking White Blood Cell");
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
	
	@Override
	public int attack(Cell aCell) {
		// TODO Auto-generated method stub
		int damage = 0;
		if(getActionPoints() >= 2) {
			if((aCell.getLocationX() + 1 == getLocationX() ||
					aCell.getLocationX() - 1 == getLocationX() ||
					aCell.getLocationY() + 1 == getLocationY() ||
					aCell.getLocationY() - 1 == getLocationY() ||
					(Math.abs(getLocationX() - aCell.getLocationX()) + Math.abs(getLocationY() - aCell.getLocationY()) <= getAttackRange())) &&
					aCell.getTeam() == Team.WBC){
				
				if(aCell.getHealth() > getAttackPoints()) {
					damage = ATTACK_POINTS;
					aCell.setHealth(aCell.getHealth() - getAttackPoints());
					System.out.println("You deal " + ATTACK_POINTS + " damages to the objective!");
				} else {
					aCell.setHealth(0);
					System.out.println("You killed the objective!");
					return 3;
				}
				setActionPoints(0);
				return 2;
			} else {
				System.out.println("The objective is out of attack range.");
				return 1;
			}
		} else
			System.out.println("This unit does not have enough action points to do so.");
			return 0;
	}

	@Override
	public String useItem() {
		// TODO Auto-generated method stub
		return null;
	}
}