package bees;

import core.Bee;

/**
 * A Bee with a large armor who can take 1 action each 2 turn
 *
 * @author Ma�l
 */
public class HugeBee extends Bee{
	
	private int cooldown=0;
	
	/**
	 * Creates a new Huge Bee.
	 * Armor: 5, Food: 4, Damage: 1
	 */
	public HugeBee(){
		super (5, 4);
	}
	
	public void action(){
		if (cooldown==0){
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else if (armor > 0) {
				moveTo(place.getExit());
			}
			cooldown=1;
		} else { cooldown=0;}
	}
	

}
