package model;

public class Bomb extends Item{
	private int damage;
	
	
	// This is a test git comment.
	public Bomb(){
		setItemName("Bomb");
	}
	
	public void setBombDamage(Cell cell){
		if (cell.getAttackPoints() < 1){
			damage = 1;
			System.out.println("1 point of damage dealt by bomb!");
		}
		else{
			damage = cell.getAttackPoints();
			System.out.println(damage + " points of damage dealt by bomb!");
		}
	}
	
	public int getDamage(){
		return damage;
	}
}
