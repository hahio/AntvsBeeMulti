package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Damaging;

/**
 * An Ant who deal damage for each bee in the same place
 */
public class FireAnt extends Ant{
	
	public Damaging damage; 
	
	/**
	 * Creates a new Fire Ant
	 * Armor: 1, Food: 4, Damage: 3, range: 0
	 */
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
				if (!bees[i].isArmored()){
					bees[i].reduceArmor(damage.getDamage(place.isNextQueen()));
				}
			leavePlace();
		}
	}
}
