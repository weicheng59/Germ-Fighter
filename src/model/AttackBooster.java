package model;

public class AttackBooster extends Item{
	private int attack;
	private boolean doublingTruth;
	
	public AttackBooster(){
		setBoost(2);
		doublingTruth = true;
		setItemName("Attack Booster");
	}
	
	public void setBoostedCellAttack(Cell cell){
		if(doubleEffectValid() != false){
			attack = cell.getAttackPoints()*getBoost();
			cell.setAttackPoints(attack);
			doublingTruth = false;
			cell.setDoublingEffectValid(doublingTruth);
		}
		else{
			System.out.println("Doubling Effect is Invalid!");
		}
	}
	
	public int getBoostedCellAttack(){
		return attack;
	}
	
	public boolean doubleEffectValid(){
		return doublingTruth;
	}
}
