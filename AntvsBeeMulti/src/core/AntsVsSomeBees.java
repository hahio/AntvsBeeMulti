package core;


import java.util.Scanner;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees {
	public static Scanner s = new Scanner(System.in);
	
	public static void main (String[] args) {
		boolean multigame;
		AntColony colony = new AntColony(1, 10, 3, 22); // specify the colony ]tunnels, length, moats, food]
		Hive hive=Hive.makeBlankHive();;// specify the attackers (the hive)
		Player player=null;
		System.out.println("Veuillez indiquer single or multiplayer ?");
		String type = s.nextLine();
		multigame=type.equals("multiplayer");
		if (!multigame)
			hive=Hive.makeTestHive();
		if (multigame){
		System.out.println("Veuillez indiquer server ou client ?");
		String role = s.nextLine();
			if (role.equals("server"))
				player = new Player();
			else
			{
				System.out.println("Veuillez indiquer ip server ?");
				String ip = s.nextLine();
				System.out.println("Veuillez indiquer port server ?");
				String port = s.nextLine();
				player = new Player(ip,port);}}
        	 
        new AntGame(colony, hive,player,multigame);}// launch the game
	}
