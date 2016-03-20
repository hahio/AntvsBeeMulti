package bees;

import core.Bee;

public class FastBee extends Bee{
	
	/**
	 * A light bee who can move 2 case in one turn
	 *
	 * @author Maël
	 */
	
	/**
	 * Creates a new Fast Bee.
	 * Armor: 1, Food: 4, Damage: 1
	 */
	public FastBee(){
		super(1, 4);
	}
	
	public void action(){
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
