package ants;

import core.AntColony;
import core.Bee;

/**
 * An Thrower Ant who can slow bee.
 *
 * @author Maël
 */
public class SlowThrowerAnt extends ThrowerAnt{
	
	/**
	 * Creates a new SlowThrower Ant.
	 * Armor: 1, Food: 4, Damage: 0, range : 3
	 */
	public SlowThrowerAnt(){
		super(4,1);
	}
	
	public void action (AntColony colony){
		Bee target = getTarget();
		if (target !=null){
			target.setTimeSlow(3);
			target.setCooldownSlow(2);
		}
	}

}
