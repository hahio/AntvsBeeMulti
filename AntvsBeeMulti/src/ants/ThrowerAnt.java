package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Damaging;

/**
 * An ant who throws leaves at bees
 */
public class ThrowerAnt extends Ant {

	private Damaging damage;

	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 4, Damage: 1, range :3
	 */
	public ThrowerAnt () {
		super(4,1);
		damage=new Damaging(1);
	}
	
	public ThrowerAnt (int i,int j) {
		super(i,j);
		damage=new Damaging(1);
	}
	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 3);
	}

	/**
	 * Attack the Closest Bee
	 */
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) 
			target.reduceArmor(damage.getDamage(this.getPlace().isNextQueen()));
	}
}
