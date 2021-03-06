package core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Player {


	private InetAddress otherIp;
	private Integer otherPort;
	private DatagramSocket socket;
	private DatagramPacket reception;
	private DatagramPacket envoi;
	private byte[] buffer = new byte[1024];
	public boolean isServer;
	
	public Player(){
		isServer=true;
		try{
		socket = new DatagramSocket();
		System.out.println("addresse du server = "+socket.getLocalAddress().getHostAddress());
		System.out.println("port du server = "+socket.getLocalPort());	
		System.out.println("\n Waiting for other player");
		reception = new DatagramPacket(buffer, buffer.length);
		socket.receive(reception);
		System.out.println("Player found");
		byte[] buffer1="patate".getBytes();
		otherIp=reception.getAddress();
        otherPort=reception.getPort();
		envoi = new DatagramPacket(buffer1, buffer1.length,otherIp,otherPort);
		socket.send(envoi);
		
        }
		catch (IOException e) {e.printStackTrace();}
	}
	
	public Player(String ip,String port){
		isServer=false;
		try{
		socket = new DatagramSocket();
		byte[] buffer1="patate".getBytes();
		envoi = new DatagramPacket(buffer1, buffer1.length,InetAddress.getByName(ip),Integer.parseInt(port));
		reception = new DatagramPacket(buffer, buffer.length);
		socket.send(envoi);
		System.out.println("Request send");
		socket.receive(reception);
		System.out.println("Request answered");
		otherIp=reception.getAddress();
        otherPort=reception.getPort();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void send(String Message){
		try{
			byte[] buffer1 = new byte[64];
			buffer1=Message.getBytes();
			envoi = new DatagramPacket(buffer1, buffer1.length,otherIp,otherPort);
			socket.send(envoi);
		}catch (IOException e) {e.printStackTrace();}
	}
	
	public String take(){
		try{
			byte[] buffer1 = new byte[64];
			reception = new DatagramPacket(buffer1, buffer1.length);
			socket.receive(reception);
		}catch (IOException e) {e.printStackTrace();}
		return new String(reception.getData());
	}
	      
}
