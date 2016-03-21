package bees;


import core.Bee;

public class CryptBee {
	
	private String send;
	
	public CryptBee(){
		send="";
	}
	public void setSend(String receive){
		send=receive;
	}
	
	public int length(){
		return send.length();
	}
	
	public void reset(){
		send="";
	}
	public String getSend(){
		return send;
	}
	
	public void add(Bee bee){
		if (bee instanceof ArmoredBee)
			send+="1";
		else if (bee instanceof FastBee)
			send+="2";
		else if (bee instanceof HugeBee)
			send+="3";
	}
	
	public Bee[] convert(){
		int size=0;
		for (int i=0;i<send.length();i++){
			if (send.charAt(i)=='1' || send.charAt(i)=='2' || send.charAt(i)=='3')
				size+=1;
		}
		Bee[] wave=new Bee[size];
		for (int i=0;i<size;i++){
			if (send.charAt(i)=='1')
				wave[i]=new ArmoredBee();
			else if (send.charAt(i)=='2')
				wave[i]=new FastBee();
			else if (send.charAt(i)=='3')
				wave[i]=new HugeBee();
		}
		return wave;
			
	}
	
}
