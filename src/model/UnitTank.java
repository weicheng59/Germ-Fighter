package model;

public class UnitTank extends Cell{

	private boolean canAttack = true;
	private final int ATTACK_POINTS = 6, HEALTH_POINTS = 15, MAX_HEALTH_POINTS = 10, ATTACK_RANGE = 1, 
					  MOVE_RANGE = 6, ACTION_POINTS = 6;
	
	
	// newborn WBC initial stats
	public UnitTank(Team team){
		super(team);
		if (team == Team.GERM)
			setCellName("Tank Germ");
		else
			setCellName("Tank White Blood Cell");
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
		if(canAttack == true){
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
		else{
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
	}*/

	@Override
	public String useItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean canAttack(){
		return canAttack;
	}
	
}