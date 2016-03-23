package ants;


/**
 * An Thrower Ant who can be sit in water place
 */
public class ScubaThrowerAnt extends ThrowerAnt{
	
	
	/**
	 * Creates a new ScubaThrower Ant.
	 * Armor: 1, Food: 5, Damage: 1, range :3
	 */
	public ScubaThrowerAnt () {
		super(5,1);
		watersafe=true;
	}
	
	/**
	 * Creates a new ScubaThrower Ant. (use for the creation of Queen Ant)
	 */
	public ScubaThrowerAnt (int foodCost, int armor) {
		super(foodCost,armor);
		watersafe=true;
	}
	
}
