package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Damaging;

public class FireAnt extends Ant{
	
	public Damaging damage; 
	
	public FireAnt(){
		super(4,1);
		damage=new Damaging(3);
	}
	
	
	@Override
	public void action(AntColony colony){
		
	}
	@Override
	public void reduceArmor (int amount) {//coucou
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
