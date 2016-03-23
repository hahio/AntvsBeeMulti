package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Damaging;

/**
 * An Ant who can't be touched by bees
 */
public class NinjaAnt extends Ant {
	
	private Damaging damage;
	
	/**
	 * Creates a new Ninja Ant.
	 * Armor: 1, Food: 6, Damage: 1, range : 0
	 */
	public NinjaAnt(){
		super(6,1);
		damage=new Damaging(1);
		blocker=false;
	}
	
	/**
	 * Attack a random bee in the same place
	 */
	public void action(AntColony colony){
		Bee[] bees=place.getBees();
		for (int i=0;i<bees.length;i++)
			bees[i].reduceArmor(damage.getDamage(place.isNextQueen()));
	}
}
