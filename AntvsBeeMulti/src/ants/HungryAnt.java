package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An Ant who kill a bees by turn(every 3 turns)
 *
 * @author Maël
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
	
	public Bee getTarget () {
		return place.getClosestBee(0, 0);
	}
	
	/**
	 * Kill a bee in the same place if cooldown==0
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
