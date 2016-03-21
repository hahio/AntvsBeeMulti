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
		if (bee instanceof NormalBee)
			send+="1";
		else if (bee instanceof ArmoredBee)
			send+="2";
		else if (bee instanceof FastBee)
			send+="3";
		else if (bee instanceof OgreBee)
			send+="4";
		else if (bee instanceof KamikazeBee)
			send+="5";
	}
	
	public Bee[] convert(){
		int size=0;
		for (int i=0;i<send.length();i++){
			if (send.charAt(i)=='1' || send.charAt(i)=='2' || send.charAt(i)=='3'|| send.charAt(i)=='4'|| send.charAt(i)=='5')
				size+=1;
		}
		Bee[] wave=new Bee[size];
		for (int i=0;i<size;i++){
			if (send.charAt(i)=='1')
				wave[i]=new NormalBee();
			else if (send.charAt(i)=='2')
				wave[i]=new ArmoredBee();
			else if (send.charAt(i)=='3')
				wave[i]=new FastBee();		
			else if (send.charAt(i)=='4')
					wave[i]=new OgreBee();
			else if (send.charAt(i)=='5')
				wave[i]=new KamikazeBee();
		}
		return wave;
			
	}
	
}
