package ants;

import core.Bee;

public class ShortThrowerAnt extends ThrowerAnt{
	
	public ShortThrowerAnt(){
		super(3,1);
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 2);
	}

}
