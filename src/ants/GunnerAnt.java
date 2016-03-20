package ants;

import core.AntColony;
import core.Containing;

/**
 * An Ant who assist the Ant and up the Ant's Damage to 1
 *  
 * @author Maël
 */
public class GunnerAnt extends Containing{
	
	/**
	 * Creates a new Gunner Ant
	 * Armor: 1, Food: 4, Damage: 0
	 */
	public GunnerAnt(){
		super(4,1);
	}
	
	public void action(AntColony colony){
		
	}
	

}
