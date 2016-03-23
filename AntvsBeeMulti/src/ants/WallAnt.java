package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant with a large armor who do nothing
 */
public class WallAnt extends Ant{
	
	/**
	 * Creates a new Wall Ant.
	 * Armor: 4, Food: 4, Damage: 0
	 */
	public WallAnt(){
		super(4,4);
	}
	
	/**
	 * do nothing
	 */
	@Override
	public void action (AntColony colony) {
	}
}
