package model;

public class LevelUp extends Item{
	private int experience;
	
	public LevelUp(){
		experience = 0;
	}
	
/*	public void levelUp(Cell cell){
		if(cell.getLevel() < 5){
			experience = cell.getCurrentExperience() - cell.getCurrentMaxExperience();
			cell.setLevel(cell.getLevel() + 1);
			cell.setCurrentExperience(0);
			cell.setCurrentMaxExperience(cell.getCurrentMaxExperience(getCurrentMaxExperience()*2));
		}
	}*/
	
	
	public int getLevelingUpExperience(){
		return experience;
	}
}
