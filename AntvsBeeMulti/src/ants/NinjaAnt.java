package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Damaging;

public class NinjaAnt extends Ant {
	
	private Damaging damage;
	
	public NinjaAnt(){
		super(6,1);
		damage=new Damaging(1);
		blocker=false;
	}
	
	public void action(AntColony colony){
		Bee[] bees=place.getBees();
		for (int i=0;i<bees.length;i++)
			bees[i].reduceArmor(damage.getDamage(place.isNextQueen()));
	}
}
