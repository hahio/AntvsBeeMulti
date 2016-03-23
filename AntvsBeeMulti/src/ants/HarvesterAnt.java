package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 */
public class HarvesterAnt extends Ant {

	/**
	 * Creates a new Harvester Ant
	 * Armor: 1, Food: 2, Damage: 0
	 */
	public HarvesterAnt () {
		super(2,1);
	}

	/**
	 * Creates a unit of Food
	 */
	@Override
	public void action (AntColony colony) {
		colony.increaseFood(1);
	}
}
