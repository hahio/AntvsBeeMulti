package core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Startmenu{
  public static boolean start() {
    String[] type = {"Single", "Multiplayer"};
    int multiplayer = JOptionPane.showOptionDialog(null, "Choose a type of game","AntvsSomeBees",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,type,type[0]);
    if (multiplayer==0)
    	return false;
    else 
    	return true;
  }
  
  public static int multiplayer(){
	  String[] type ={"Server","Client"};
	  int choice = JOptionPane.showOptionDialog(null, "Choose your position", "Multiplayer", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,type,type[0]);
	return choice; 
  }
  
  public static String[] client(){
	      String ip = JOptionPane.showInputDialog(null, "Enter ip", "Client", JOptionPane.QUESTION_MESSAGE);
	      String port = JOptionPane.showInputDialog(null, "Enter port", "Client", JOptionPane.QUESTION_MESSAGE);
	    String[] reponse={ip,port};
	      return reponse;
	  }
  }
