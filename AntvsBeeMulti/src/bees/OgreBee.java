package bees;

import core.AntColony;
import core.Bee;

/**
 * A Bee with a large armor who can do one action each two turn
 */
public class OgreBee extends Bee{
	
	private boolean cooldown=true;
	
	/**
	 * Creates a new Huge Bee.
	 * Armor: 5, Food: 8, Damage: 4
	 */
	public OgreBee(){
		super (10, 8);
		setDamage(4);
	}
	
	/**
	 * Can do only one action each two turn
	 */
	@Override
	public void action(AntColony colony){
		if (cooldown){
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else if (armor > 0) {
				moveTo(place.getExit());
			}
			cooldown=false;
		} else { cooldown=true;}
	}
	

}
