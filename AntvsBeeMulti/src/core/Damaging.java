package core;

public class Damaging {
	
	public int baseDamage;
	
	
	public Damaging(int baseDamage){
		this.baseDamage=baseDamage;
	}
	
	public int getDamage(boolean isNextQueen){
		if (isNextQueen)
			return baseDamage*2;
		else
			return baseDamage;
	}
}
