package ants;



public class ScubaThrowerAnt extends ThrowerAnt {
	
	public ScubaThrowerAnt () {
		super(5,1);
		watersafe=true;
	}
	public ScubaThrowerAnt (int food,int armor) {
		super(food,armor);
		watersafe=true;
	}
	
}
