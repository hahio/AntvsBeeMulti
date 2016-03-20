package ants;


import core.AntColony;
import core.Bee;

/**
 * An Thrower Ant who can stun bee.
 *
 * @author Maël
 */
public class StunThrowerAnt extends ThrowerAnt{
	
	/**
	 * Creates a new StunHtrower Ant.
	 * Armor: 1, Food: 6, Damage: 0, range : 3
	 */
	public StunThrowerAnt(){
		super(6,1);
	}
	
	public void action (AntColony colony){
		Bee target = getTarget();
		if (target !=null){
			target.setTimeStun(1);
		}
	}

}
