package ants;

import core.Bee;

/**
 * An Thrower Ant who only can attack in long distance
 *
 * @author Maël
 */
public class LongThrowerAnt extends ThrowerAnt{
	
	/**
	 * Creates a new LongThrower Ant.
	 * Armor: 1, Food: 3, Damage: 1, range : only 4+
	 */
	public LongThrowerAnt(){
		super(3,1);
	}
	
	public Bee getTarget () {
		return place.getClosestBee(4, 1000);
	}

}
