package ants;


import core.AntColony;
import core.Bee;

public class StunThrowerAnt extends ThrowerAnt{
	
	public StunThrowerAnt(){
		super(6,1);
	}
	
	public void action (AntColony colony){
		Bee target = getTarget();
		if (target !=null){
			target.setTimeStun(1);
		}
	}

}
