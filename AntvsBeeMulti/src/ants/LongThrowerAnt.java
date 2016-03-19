package ants;

import core.Bee;

public class LongThrowerAnt extends ThrowerAnt{
	
	public LongThrowerAnt(){
		super(3,1);
	}
	
	public Bee getTarget () {
		return place.getClosestBee(4, -1);
	}

}
