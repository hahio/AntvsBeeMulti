package bees;

import core.Bee;

/**
 * A Bee who can resist to explosive damage (caused by FireAnts)
 *
 * @author Maël
 */
public class ArmoredBee extends Bee{
	
	/**
	 * Creates a new Armored Bee.
	 * Armor: 2, Food: 4, Damage: 1
	 */
	public ArmoredBee(){
		super (2, 4);
		this.isArmored=true;
	}

}
