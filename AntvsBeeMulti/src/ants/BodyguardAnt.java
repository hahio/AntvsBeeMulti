package ants;

import core.AntColony;
import core.Containing;

/**
 * An Ant who protect the Ant who is in the same place
 *
 * @author Maël
 */

public class BodyguardAnt extends Containing {
	
	
	/**
	 * Creates a new Bodyguard Ant.
	 * Armor: 2, Food: 5, Damage: 0
	 */
	public BodyguardAnt(){
		super(5,2);
	}
	/**
	 * Do nothing
	 */
	@Override
	public void action (AntColony colony) {
	}
}
