package ants;



public class ScubaThrowerAnt extends ThrowerAnt{
	
	public ScubaThrowerAnt () {
		super(5,1);
		watersafe=true;
	}
	
	public ScubaThrowerAnt (int foodCost, int armor) {
		super(foodCost,armor);
		watersafe=true;
	}
	
}
