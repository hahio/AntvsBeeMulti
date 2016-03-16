package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class HungryAnt extends Ant{
	
	public int coolDown;
	
	public HungryAnt(){
		super(4,1);
		coolDown=0;
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 0);
	}
	
	@Override
	public void action(AntColony colony){
		Bee target = getTarget();
		if (coolDown == 0 && target !=null){
			target.reduceArmor(target.getArmor());
			coolDown=3;
		}
		if (coolDown >0)
			coolDown-=1;
	}
}
