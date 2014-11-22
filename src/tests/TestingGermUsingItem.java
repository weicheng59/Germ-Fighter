package tests;

import static org.junit.Assert.*;
import model.AttackBooster;
import model.Bomb;
import model.Cell;
import model.GermBasic;
import model.HealthPack;
import model.Item;
import model.Cell.Team;

import org.junit.Test;

public class TestingGermUsingItem {
	private Team team = Team.GERM;
	
	@Test
	public void testingGermBasicUsingAttackBooster(){
		Cell user = new GermBasic(team);
		AttackBooster attackBooster = new AttackBooster();
		
		// cell has not used an Attack Booster item yet; standard attack points
		assertEquals(user.getDoublingEffectValid(), true);		
		assertEquals(user.getAttackPoints(), 4);
		attackBooster.setBoostedCellAttack(user);
		
		// cell has used an Attack Booster item; doubled attack points
		assertEquals(user.getDoublingEffectValid(), false);
		assertEquals(user.getAttackPoints(), 8);
		
		// cell has used an Attack Booster item and tries again (impossible scenario); same attack points
		attackBooster.setBoostedCellAttack(user);
		assertEquals(user.getAttackPoints(), 8);
	}
	
	@Test
	public void testingGermBasicUsingHealthPack(){
		Cell user = new GermBasic(team);
		HealthPack healthPack = new HealthPack();
		
		// cell has not taken damage
		assertEquals(user.getMaxHealth(), 10);
		
		// cell has lost half its health; fully healed
		user.setHealth(5);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), user.getMaxHealth());
		
		// cell has lost less than half its health; fully healed
		user.setHealth(8);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), user.getMaxHealth());
		
		// cell has lost more than half its health; partially healed
		user.setHealth(3);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), 8);
		
		// cell has lost no health at all; no healing
		user.setHealth(10);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), user.getMaxHealth());
		
		// cell with odd numbered health
		user.setHealth(11);	
		
		// cell has lost less than half its health; fully healed
		user.setHealth(6);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), user.getMaxHealth());
		
		// cell has lost more than half its health; partially healed
		user.setHealth(5);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), 10);
		
		// cell has lost no health at all; no healing
		user.setHealth(11);
		healthPack.regainingHealth(user);
		assertEquals(user.getHealth(), user.getMaxHealth());
	}
	
	@Test
	public void testingGermBasicUsingBomb(){
		Cell user = new GermBasic(team);
		Bomb bomb = new Bomb();
		
		// cell's attack points confirmed
		assertEquals(user.getAttackPoints(), 4);
		
		// used a bomb; this is the damage dealt
		bomb.setBombDamage(user);
		assertEquals(bomb.getDamage(), 4);
		
		// used a bomb after attack was doubled, this is the damage dealt
		AttackBooster attackBooster = new AttackBooster();
		attackBooster.setBoostedCellAttack(user);
		bomb.setBombDamage(user);
		assertEquals(bomb.getDamage(), 8);
		
		// cell has no attack power default damage is 1
		user.setAttackPoints(0);
		bomb.setBombDamage(user);
		assertEquals(bomb.getDamage(), 1);
	}
	
	/*
	 @Test
	 public void testingGermBasicUnitUsingLevelUp(){
	 	Cell user = new GermBasic();
	 	LevelUp levelUp = new LevelUp();
	 	
	 	// cell's experience are at 0, level is 1, and max experience is 2
	 	assertEqual(user.getCurrentExperience(), 0);
	 	assertEqual(user.Level(), 1);
	 	
	 	// cell's use boosts from level 1 to level 2
	 	levelUp.levelUp(user);
	 	assertEqual(user.getCurrentExperience(), 0)
	 	
	 	//
	 }
	 */
}
