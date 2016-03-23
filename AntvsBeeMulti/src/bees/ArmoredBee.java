package bees;

import core.Bee;

/**
 * A Bee who can resist to explosive damage (caused by FireAnts)
 */
public class ArmoredBee extends Bee{
	
	/**
	 * Creates a new Armored Bee.
	 * Armor: 3, Food: 4, Damage: 1
	 */
	public ArmoredBee(){
		super (3, 4);
		this.isArmored=true;
	}

}
