package main.java;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Client extends JFrame {
	private String destinationIPAddr;	//�ؼЪ�IP��m
	private int destinationPortNum;		//�ؼЪ�port number
	private Socket socket;		//�ŧisocket
	public static PrintWriter writer;	//�ŧiwriter,�ΨӶǰe�T����server
	public static int ready,Index,waitans,solve,init,wrong,chara;	//�ŧi�|�Ψ줧�����ܼ�
	public static int begin ;
	//public Main game ;
	public static Main game = new Main() ;
	public Client() {	//��l��
		waitans = 0;
		ready = 0;
		Index = 0;
		solve = 0;
		init = 0;
		wrong = 0;
		begin = 1 ;
		chara = 0 ;
	}
	public Client(String IPAddress, int portNum) {	//��l�Ƴ]�w
		this();
		this.destinationIPAddr = IPAddress;
		this.destinationPortNum = portNum;
	}
	public Client setIPAddress(String IPAddress) {	//�]�wIP��m
		this.destinationIPAddr = IPAddress;
		return this;
	}
	public Client setPort(int portNum) {	//�]�wport number
		this.destinationPortNum = portNum;
		return this;
	}
	public void connect() {	
		try{	//create a socket
			this.socket = new Socket(this.destinationIPAddr,this.destinationPortNum);
			writer = new PrintWriter(new 							///writer �ΨӶǰT����server
					OutputStreamWriter(socket.getOutputStream()));	
			BufferedReader reader = new BufferedReader(new		///reader �Ψӱ���server���T��
					InputStreamReader(socket.getInputStream()));
			ClientThread thread = new ClientThread(reader);	//�}�@��thread�A�Ψӱ���server�T��
			thread.start();		//��Thread�}�l
			System.out.println("Client : writer"+writer);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(ConnectException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	class ClientThread extends Thread{		//��inner class�A���������T����thread
		private BufferedReader reader;		//�ŧireader
		public ClientThread(BufferedReader reader){
			this.reader = reader;
		}
		public void run(){
			while(true){	//�n�H�ɺʵ�server�O�_���ǰT���L��
				try{
					
					String line = this.reader.readLine();	//�Y��server�ǰT���A�hline��server�Ǥ��T��
					System.out.println("Client message :"+line);
					if(line.equals("ready")){	//�Yserver�Ǫ��T���Oready
						ready = 1;	//�h�N��client����H�w�[�J�A�B�ݭn��l��
						init = 1;	
					}
					else if(line.equals("char")){
						System.out.println("inclientstate");
						chara = 1 ;
						ready = 1;
						System.out.println("ready == : "+ready);
					}
					
					else if(line.equals("solve")){	//�Yserver�Ǫ��T���Osolve
						solve = 1;	//�h�N��client�w�ѨM���D
						waitans = 0;    //�����A���ݥt���J����
						init = 1;
					}else if(line.equals("wrong")){	//�Yserver�Ǫ��T���Owrong
						wrong = 1;	//�h�N��client����J�����P�A�ݭ��s��J
						waitans = 0;	//�����A���ݥt���J����
						init = 1;
					}else{		//��L���p�h��server�ǰe�n�ϥιϤ���index��
						Index = Integer.parseInt(line);
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();	//�s�Ф@��client
		
		client.setIPAddress("127.0.0.1").setPort(8000).connect();	//connect to server
		
		game.start();
		
	}

}
