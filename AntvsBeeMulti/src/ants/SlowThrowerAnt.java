package ants;

import core.AntColony;
import core.Bee;

public class SlowThrowerAnt extends ThrowerAnt{
	
	public SlowThrowerAnt(){
		super(4,1);
	}
	
	public void action (AntColony colony){
		Bee target = getTarget();
		if (target !=null){
			target.setTimeSlow(3);
			target.setCooldownSlow(2);
		}
	}

}
