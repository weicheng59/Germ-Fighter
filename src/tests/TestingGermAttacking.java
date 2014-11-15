package tests;

import static org.junit.Assert.*;
import model.Cell;
import model.GermBasic;
import model.GermMedic;
import model.GermRanged;
import model.GermSplashAttacker;
import model.GermTank;

import org.junit.Test;

public class TestingGermAttacking {
	private Cell target = new GermBasic();
	
//	Germ Basic unit attacking unit test [[COMPLETED]]
	@Test
	public void testingGermBasicAttacking(){
		Cell basic = new GermBasic();
		
		System.out.println("***" + "\n" + "<= Testing A Basic Germ Unit Attacking =>");
		
		// cannot attack
		basic.setActionPoints(1);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack was successful (above)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (left)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (right)
		basic.setActionPoints(6);
		basic.setLocationX(1);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (below)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack killed the target (above)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (left)
		basic.setActionPoints(6);
		basic.setLocationX(1);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (right)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (below)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(basic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// enough action points, target out of range (too far above)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(2);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (too far left)
		basic.setActionPoints(6);
		basic.setLocationX(2);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (too far right)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (top left)
		basic.setActionPoints(6);
		basic.setLocationX(1);
		basic.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (top right)
		basic.setActionPoints(6);
		basic.setLocationX(1);
		basic.setLocationY(1);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (bottom left)
		basic.setActionPoints(6);
		basic.setLocationX(1);
		basic.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (bottom right)
		basic.setActionPoints(6);
		basic.setLocationX(1);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (too far down)
		basic.setActionPoints(6);
		basic.setLocationX(0);
		basic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(basic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		System.out.println("<= Testing A Basic Germ Unit Attacking =>" + "\n");
	}
	
// 	Germ Ranged unit attacking unit test [[COMPLETED]]
	@Test
	public void testingGermRangedAttacking(){
		Cell ranged = new GermRanged();
		System.out.println("***" + "\n" + "<= Testing A Ranged Germ Unit Attacking =>");
		
		// cannot attack
		ranged.setActionPoints(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack successful (close above, 1 space away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (close left, 1 space away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (close right, 1 space away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (close below, 1 space away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (away above, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(2);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (away left, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (away right, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (away below, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful  (diagonal top left, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful  (diagonal top right, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(1);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful  (diagonal lower left, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful  (diagonal lower right, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (first upper left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (first upper right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(1);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (first lower left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (first lower right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (second upper left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(2);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (second upper right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(2);
		target.setLocationX(1);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (second lower left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (second lower right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (far above, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(3);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (far left, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(3);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (far right, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(3);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack successful (far below, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(3);
		target.setHealth(10);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
			
		// attack killed the target (close below, 1 space away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");

		// attack killed the target (away below, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
	
		// attack killed target (diagonal lower right, 2 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (first upper left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (first upper right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(1);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (first lower left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (first lower right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (second upper left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(2);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (second upper right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(2);
		target.setLocationX(1);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (second lower left semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(1);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed target (second lower right semi-diagonal, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(2);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (far above, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(3);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (far left, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(3);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (far right, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(3);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (far below, 3 spaces away)
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(3);
		target.setHealth(1);
		assertEquals(ranged.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// enough action points, target out of range above
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(4);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range left
		ranged.setActionPoints(6);
		ranged.setLocationX(4);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range right
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(4);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range below
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(4);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range diagonal upper left
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(2);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range diagonal upper right
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(2);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range diagonal lower left
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range diagonal lower right
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range first upper left semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(3);
		ranged.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range first upper right semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(1);
		target.setLocationX(3);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range first lower left semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(4);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range first lower right semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(3);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range second upper left semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(3);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range second upper right semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(4);
		target.setLocationX(1);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range second lower left semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(2);
		ranged.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(3);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range second lower right semi-diagonal
		ranged.setActionPoints(6);
		ranged.setLocationX(0);
		ranged.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(3);
		target.setHealth(1);
		assertEquals(ranged.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		System.out.println("<= Testing A Ranged Germ Unit Attacking =>" + "\n");
	}
	
	//TODO Germ Tank unit attacking test [[IN PROGRESS]]
	@Test
	public void testingGermTankAttacking(){
		Cell tank = new GermTank();
		
		System.out.println("***" + "\n" + "<= Testing A Tank Germ Unit Attacking =>");
		
		System.out.println("<= Testing A Tank Germ Unit Attacking =>");		
	}
	
// Germ Splash Attacker unit attacking test [[COMPLETED]]
	@Test
	public void testingGermSplashAttackerAttacking(){
		Cell splashAttacker = new GermSplashAttacker();
		
		System.out.println("***" + "\n" + "<= Testing A Splash Attacker Germ Unit Attacking =>");
		
		// cannot attack
		splashAttacker.setActionPoints(1);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack was successful (above)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(1);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (below)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (top left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(1);
		splashAttacker.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (top right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(1);
		splashAttacker.setLocationY(1);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (bottom left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (bottom right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack killed the target (above)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(1);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (below)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(splashAttacker.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// enough action points, target out of range (above)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (below)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (top left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (top right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (bottom left)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (bottom right)
		splashAttacker.setActionPoints(6);
		splashAttacker.setLocationX(0);
		splashAttacker.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(splashAttacker.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		System.out.println("<= Testing A Splash Attacker Germ Unit Attacking =>" + "\n");
	}
	
//	Germ Medic unit attacking unit test [[COMPLETED]]
	@Test
	public void testingGermMedicAttacking(){
		Cell medic = new GermMedic();
		
		
		System.out.println("***" + "\n" + "<= Testing A Medic Germ Unit Attacking =>");
		
		// cannot attack
		medic.setActionPoints(1);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack was successful (above)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (left)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (right)
		medic.setActionPoints(6);
		medic.setLocationX(1);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack was successful (below)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// attack killed the target (above)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (left)
		medic.setActionPoints(6);
		medic.setLocationX(1);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (right)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(0);
		target.setLocationX(1);
		target.setLocationY(0);
		target.setHealth(1);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// attack killed the target (below)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(1);
		assertEquals(medic.attack(target), true);
		System.out.println("Target has " + target.getHealth() + " health left." + "\n");
		
		// enough action points, target out of range (too far above)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(2);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (too far left)
		medic.setActionPoints(6);
		medic.setLocationX(2);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (too far right)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (top left)
		medic.setActionPoints(6);
		medic.setLocationX(1);
		medic.setLocationY(1);
		target.setLocationX(0);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (top right)
		medic.setActionPoints(6);
		medic.setLocationX(1);
		medic.setLocationY(1);
		target.setLocationX(2);
		target.setLocationY(0);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (bottom left)
		medic.setActionPoints(6);
		medic.setLocationX(1);
		medic.setLocationY(0);
		target.setLocationX(2);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (bottom right)
		medic.setActionPoints(6);
		medic.setLocationX(1);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(1);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		
		// enough action points, target out of range (too far down)
		medic.setActionPoints(6);
		medic.setLocationX(0);
		medic.setLocationY(0);
		target.setLocationX(0);
		target.setLocationY(2);
		target.setHealth(10);
		assertEquals(medic.attack(target), false);
		System.out.println("Target has " + target.getHealth() + " health left.");
		System.out.println("<= Testing A Medic Germ Unit Attacking =>" + "\n");
	}
}
