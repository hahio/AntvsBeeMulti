package core;

/**
 * Represents a Bee
 *
 * @author YOUR NAME HERE
 */
public class Bee extends Insect {

	private int DAMAGE = 1;
	protected int foodCost;
	protected boolean isArmored=false;

	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor
	 *            The bee's armor
	 */
	public Bee (int armor) {
		super(armor);
		watersafe=true;
		
	}
	
	public Bee (int armor, int foodCost){
		super(armor);
		watersafe=true;
		this.foodCost=foodCost;
	}

	/**
	 * Deals damage to the given ant
	 *
	 * @param ant
	 *            The ant to sting
	 */
	public void sting (Ant ant) {
		ant.reduceArmor(DAMAGE);
	}

	/**
	 * Moves to the given place
	 *
	 * @param place
	 *            The place to move to
	 */
	public void moveTo (Place place) {
		if (this.place!=null)
			this.place.removeInsect(this);
		if (place !=null){
			place.addInsect(this);
		}
		
		
			
	}

	@Override
	public void leavePlace () {
		if (place!=null){
			place.removeInsect(this);
		}
		
	}
	
	public boolean isArmored(){
		return isArmored;
	}
	
	

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 *
	 * @return if the bee can advance
	 */
	public boolean isBlocked () {
		if (place==null || place.getAnt()==null)
				return false;
		else
			return (place.getAnt().isBlocker());
	}

	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	@Override
	public void action (AntColony colony) {
		if (isBlocked()) {
			sting(place.getAnt());
		}
		else if (armor > 0) {
			moveTo(place.getExit());
		}
	}

	public int getFoodCost() {
		return foodCost;
	}
	
	public void setDamage(int DAMAGE){
		this.DAMAGE=DAMAGE;
	}
}
