package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Damaging;

/**
 * An Ant who deal damage in the entire line when she die
 *
 * @author Maël
 */
public class FireAnt extends Ant{
	
	/**
	 * Creates a new Fire Ant
	 * Armor: 1, Food: 4, Damage: +inf, range: 0
	 */
	
	public Damaging damage; 
	
	public FireAnt(){
		super(4,1);
		damage=new Damaging(3);
	}
	
	/**
	 * Do nothing
	 */
	@Override
	public void action(AntColony colony){
		
	}
	
	/**
	 * When she die, deal damage for all the bee who are in this ant's place
	 */
	@Override
	public void reduceArmor (int amount) {
		armor -= amount;
		if (armor <= 0) {
			System.out.println(this + " ran out of armor and expired");
			Bee[] bees=place.getBees();
			for (int i=0;i<bees.length;i++)
				bees[i].reduceArmor(damage.getDamage(place.isNextQueen()));
			leavePlace();
		}
	}
}
