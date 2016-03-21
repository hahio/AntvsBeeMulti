package core;



/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees {
	public static void main (String[] args) {
		AntColony colony = new AntColony(3, 10, 3, 22); // specify the colony ]tunnels, length, moats, food]
		Hive hive=Hive.makeBlankHive();// specify the attackers (the hive)
		Player player=null;
		boolean multigame=Startmenu.start();
		if (!multigame)
			hive=Hive.makeTestHive();
		if (multigame){
			int role=Startmenu.multiplayer();
			if (role==0)
				player = new Player();
			else
			{
				String[] answer=Startmenu.client();
				player = new Player(answer[0],answer[1]);}}
        	 
        new AntGame(colony, hive,player,multigame);}// launch the game
	}
