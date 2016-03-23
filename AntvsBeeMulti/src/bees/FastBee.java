package bees;

import core.AntColony;
import core.Bee;


/**
 * A light bee who can do two action in one turn
 */
public class FastBee extends Bee{
	
	
	
	/**
	 * Creates a new Fast Bee.
	 * Armor: 1, Food: 4, Damage: 1
	 */
	public FastBee(){
		super(1, 4);
	}
	
	/**
	 * Do 2 action in each turn
	 */
	@Override
	public void action(AntColony colony){
		for(int i=0;i<2;i++){
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else if (armor > 0) {
				moveTo(place.getExit());
			}
		}
	}

}
