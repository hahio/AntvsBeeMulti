package bees;

import core.Ant;
import core.Bee;

/**
 * A Bee who damage Ant in the same place when she is in the same place of an Ant who can bl
 *
 * @author Maël
 */
public class KamikazeBee extends Bee{
	
	/**
	 * Creates a new Kamikaze Bee.
	 * Armor: 2, Food: 3, Damage: 1
	 */
	public KamikazeBee(){
		super (2, 3);
	}
	
	public void action(){
		if (isBlocked()) {
			Ant ant=place.getAnt();
			ant.reduceArmor(ant.getArmor());
			this.reduceArmor(this.getArmor());
		}
		else if (armor > 0) {
			moveTo(place.getExit());
		}
	}

}
