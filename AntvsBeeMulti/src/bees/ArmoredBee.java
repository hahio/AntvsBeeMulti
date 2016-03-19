package bees;

import core.Bee;

public class ArmoredBee extends Bee{
	
	public ArmoredBee(int foodCost, int armor){
		super (armor, foodCost);
		this.isArmored=true;
	}

}
