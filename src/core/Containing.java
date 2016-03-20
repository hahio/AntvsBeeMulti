package core;

public abstract class Containing extends Ant{
	
	private Ant ant;
	
	public Containing(int armor){
		super(armor);
	}
	
	public Containing(int food,int armor){
		super(food,armor);
	}
	
	
	public void addAnt (Ant ant) {
		if (!(ant instanceof Containing)) {
			this.ant = ant;
			this.ant.setPlace(this.place);
		}
		else {
			System.out.println("Already an ant "); // report error
		}
	}

	
	public void removeAnt (Ant ant) {
		if (this.ant != null) {
			this.ant = null;
		}
		else {
			System.out.println("There is no ant "); // report error
		}
	}
	public Ant getAnt(){
		return this.ant;
	}
	
	
}
