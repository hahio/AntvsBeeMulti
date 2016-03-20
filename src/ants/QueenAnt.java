package ants;

import core.AntColony;
import core.Bee;
import core.Damaging;

public class QueenAnt extends ScubaThrowerAnt {
	
	public static int nbQueenAnt=0;
	private Damaging damage;
	
	public QueenAnt(){
		super(6,1);
		damage=new Damaging(1);
		nbQueenAnt+=1;
	}
	
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
