package bees;

import core.Bee;

/**
 * A Bee with a large armor who can take 1 action each 2 turn
 *
 * @author Maël
 */
public class OgreBee extends Bee{
	
	private boolean cooldown=true;
	
	/**
	 * Creates a new Huge Bee.
	 * Armor: 5, Food: 4, Damage: 1
	 */
	public OgreBee(){
		super (5, 4);
	}
	
	public void action(){
		if (cooldown){
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else if (armor > 0) {
				moveTo(place.getExit());
			}
			cooldown=false;
		} else { cooldown=false;}
	}
	

}
