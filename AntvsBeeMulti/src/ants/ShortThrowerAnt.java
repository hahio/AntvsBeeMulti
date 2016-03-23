package ants;

import core.Bee;

/**
 * An Thrower Ant who only can attack in short distance
 */
public class ShortThrowerAnt extends ThrowerAnt{
	
	
	/**
	 * Creates a new ShortThrower Ant.
	 * Armor: 1, Food: 3, Damage: 1, range : 2
	 */
	public ShortThrowerAnt(){
		super(3,1);
	}
	
	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 2);
	}

}
