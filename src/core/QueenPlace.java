package core;

import java.util.ArrayList;

public class QueenPlace extends Place{
	
	private Place queenPlace;
	
	public QueenPlace(String name, Place exit){
		super(name,exit);
	}
	
	public void setQueenPlace(Place queenPlace){
		this.queenPlace=queenPlace;
	}
	
	@Override
	public Bee[] getBees(){
		ArrayList<Bee> allBees =new ArrayList<Bee>();
		for (Bee b:this.getBees())
			allBees.add(b);
		if (queenPlace!=null)
			for (Bee b:queenPlace.getBees())
				allBees.add(b);
		return allBees.toArray(new Bee[0]);
	}
	
}
