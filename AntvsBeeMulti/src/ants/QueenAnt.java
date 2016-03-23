package ants;

import core.AntColony;
import core.Bee;
import core.Damaging;

/**
 * A Queen Ant who can boost the Ant who are next to her.
 */
public class QueenAnt extends ScubaThrowerAnt {
	
	public static int nbQueenAnt=0;
	private Damaging damage;
	
	/**
	 * Creates a new Queen Ant.
	 * Armor: 1, Food: 6, Damage: 1, range : 3
	 */
	public QueenAnt(){
		super(6,1);
		damage=new Damaging(1);
		nbQueenAnt+=1;
	}
	
	/**
	 * Attack the closest Bee and boost Ants(a Ant can be boosted only one time)
	 */
	@Override
	public void action(AntColony colony){
		colony.setQueenPlace(this.getPlace());
		if (this.getPlace()!=null)
			this.getPlace().getEntrance().setNextQueen();
		if (this.getPlace()!=null)
			this.getPlace().getExit().setNextQueen();
		Bee target = getTarget();
		if (target != null) 
			target.reduceArmor(damage.getDamage(this.getPlace().isNextQueen()));
	}
}
