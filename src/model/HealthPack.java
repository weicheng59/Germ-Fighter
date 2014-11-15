package model;

public class HealthPack extends Item{
	private int health;
	
	public HealthPack(){
		health = 0;
		setItemName("Health Pack");
	}
	
	public void regainingHealth(Cell cell){
		if(cell.getMaxHealth() % 2 != 0)
			health = (cell.getMaxHealth() - 1)/2;
		else{
			health = cell.getMaxHealth()/2;
		}
		
		if(cell.getHealth() < cell.getMaxHealth()/2){
			cell.setHealth(health + cell.getHealth());
		}
		else if(cell.getHealth() <= (cell.getMaxHealth() - 1)/2){
			cell.setHealth(health + cell.getHealth());
		}
		else if(cell.getHealth() == cell.getMaxHealth()){
			System.out.println("Health already full!");
		}
		else{
			cell.setHealth(cell.getMaxHealth());
		}
	}
	
	
	public int getHealthToBeRegained(){
		return health;
	}
}
