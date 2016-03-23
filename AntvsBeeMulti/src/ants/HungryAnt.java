package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An Ant who kill a bees by turn(every 3 turns)
 */
public class HungryAnt extends Ant{
	
	public int coolDown;
	
	/**
	 * Creates a new Hungry Ant
	 * Armor: 1, Food: 4, Damage: +inf, range: 0
	 */
	public HungryAnt(){
		super(4,1);
		coolDown=0;
	}
	
	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 0);
	}
	
	/**
	 * Kill a random bee in the same place if she can
	 */
	@Override
	public void action(AntColony colony){
		Bee target = getTarget();
		if (coolDown == 0 && target !=null){
			target.reduceArmor(target.getArmor());
			coolDown=3;
		}
		if (coolDown >0)
			coolDown-=1;
	}
}
