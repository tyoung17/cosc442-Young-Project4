package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1, r2, r3, r4, r5;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(5);
		r1.setAmtMilk(5);
		r1.setAmtSugar(5);
		r1.setAmtChocolate(5);
		
		r2 = new Recipe();
		r2.setName("Frappuccino");
		r2.setPrice(50);
		r2.setAmtCoffee(6);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setPrice(50);
		r3.setAmtCoffee(6);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(0);
		
		r4 = new Recipe();
		r4.setName("Cappuccino");
		r4.setPrice(50);
		r4.setAmtCoffee(6);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(0);
		
		r5 = new Recipe();
		r5.setName("Espresso");
		r5.setPrice(50);
		r5.setAmtCoffee(16);
		r5.setAmtMilk(25);
		r5.setAmtSugar(25);
		r5.setAmtChocolate(25);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	public void testAddRecipe2() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		
		assertFalse(cm.addRecipe(r5));
	}
	
	public void testCheckRecipe1() {
		
	}
	
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	
	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testEditRecipe2() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertFalse(cm.editRecipe(r1, newRecipe));
	}
	
	public void testAddInventory1() {
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 50);
		
		assertTrue(cm.addInventory(3, 3, 3, 3));
		
	}
	
	public void testAddInventory2() {
		assertFalse(cm.addInventory(-1, 5, 5, 5));
		
	}

	public void testAddInventory3() {
		assertFalse(cm.addInventory(5, -1, 5, 5));
	}

	public void testAddInventory4() {
		assertFalse(cm.addInventory(5, 5, -1, 5));
	}
	
	public void testAddInventory5() {
		assertFalse(cm.addInventory(5, 5, 5, -1));
	}
	
	public void testMakeCoffee1() {
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1, 50));
	}
	
	public void testMakeCoffee2() {
		cm.addRecipe(r1);
		assertEquals(35, cm.makeCoffee(r1, 35));
	}
	
	public void testMakeCoffee3() {
		cm.addRecipe(r5);
		assertEquals(55, cm.makeCoffee(r5, 55));
	}
	
	public void testGetRecipeForName1() {
		cm.addRecipe(r1);
		//cm.getRecipeForName("Coffee");
		assertEquals(r1, cm.getRecipeForName("Coffee"));
	}
	
}