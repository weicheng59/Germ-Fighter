package tests;

import static org.junit.Assert.*;
import model.Cell;
import model.GermBasic;
import model.GermMedic;
import model.GermRanged;
import model.GermSplashAttacker;
import model.GermTank;
import model.Item;

import org.junit.Test;

public class TestingGermInitialUnitStats {
	private Item testItem;
	
	@Test
	public void testingGermBasicInitialUnit(){
		Cell germ = new GermBasic();
		
		assertEquals(germ.getCell(), "Basic");
		assertEquals(germ.getAttackPoints(), 4);
		assertEquals(germ.getHealth(), 10);
		assertEquals(germ.getAttackRange(), 1);
		assertEquals(germ.getMoveRange(), 6);
		assertEquals(germ.getActionPoints(), 6);
		assertEquals(germ.getIcon(), "[G]");
		assertEquals(germ.getItem(), null);	
	}
	
	@Test
	public void testingGermRangedInitialUnit(){
		Cell germ = new GermRanged();
		
		assertEquals(germ.getCell(), "Ranged");
		assertEquals(germ.getAttackPoints(), 4);
		assertEquals(germ.getHealth(), 8);
		assertEquals(germ.getAttackRange(), 3);
		assertEquals(germ.getMoveRange(), 6);
		assertEquals(germ.getActionPoints(), 6);
		assertEquals(germ.getIcon(), "[G]");
		assertEquals(germ.getItem(), null);	
	}
	
	@Test
	public void testingGermTankInitialUnit(){
		Cell germ = new GermTank();
		
		assertEquals(germ.getCell(), "Tank");
		assertEquals(germ.getAttackPoints(), 3);
		assertEquals(germ.getHealth(), 15);
		assertEquals(germ.getAttackRange(), 1);
		assertEquals(germ.getMoveRange(), 4);
		assertEquals(germ.getActionPoints(), 4);
		assertEquals(germ.getIcon(), "[G]");
		assertEquals(germ.getItem(), null);	
	}
	
	@Test
	public void testingGermSplashAttackerInitialUnit(){
		Cell germ = new GermSplashAttacker();
		
		assertEquals(germ.getCell(), "Splash Attacker");
		assertEquals(germ.getAttackPoints(), 3);
		assertEquals(germ.getHealth(), 8);
		assertEquals(germ.getAttackRange(), 1);
		assertEquals(germ.getMoveRange(), 5);
		assertEquals(germ.getActionPoints(), 5);
		assertEquals(germ.getIcon(), "[G]");
		assertEquals(germ.getItem(), null);	
	}
	
	@Test
	public void testingGermMedicInitialUnit(){
		Cell germ = new GermMedic();
		
		assertEquals(germ.getCell(), "Medic");
		assertEquals(germ.getAttackPoints(), 4);
		assertEquals(germ.getHealth(), 10);
		assertEquals(germ.getAttackRange(), 1);
		assertEquals(germ.getMoveRange(), 6);
		assertEquals(germ.getActionPoints(), 6);
		assertEquals(germ.getIcon(), "[G]");
		assertEquals(germ.getItem(), null);	
	}
}
