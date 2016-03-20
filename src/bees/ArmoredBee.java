package bees;

import core.Bee;

/**
 * An Bee who can resist to explosive damage (caused by FireAnts)
 *
 * @author Ma�l
 */
public class ArmoredBee extends Bee{
	
	/**
	 * Creates a new Bodyguard Ant.
	 * Armor: 2, Food: 4, Damage: 1
	 */
	public ArmoredBee(){
		super (2, 4);
		this.isArmored=true;
	}

}