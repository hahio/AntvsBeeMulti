package ants;

import core.AntColony;
import core.Bee;

/**
 * An Thrower Ant who only can attack in long distance
 */
public class LongThrowerAnt extends ThrowerAnt{
	
	/**
	 * Creates a new LongThrower Ant.
	 * Armor: 1, Food: 3, Damage: 1, range : only 4+
	 */
	public LongThrowerAnt(){
		super(3,1);
	}
	
	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(4, AntColony.MAX_TUNNEL_LENGTH);
	}

}
