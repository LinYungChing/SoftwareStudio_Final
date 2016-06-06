package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Server {
	private int Index,ansnum;  //�ŧi�|�Ψ줧�ܼ�
	private static int num ;
	private int[] check = new int[51]; 	//���}�C���ΨӲ��ͤ����Ƥ��ü�
	private ServerSocket serverSocket;	//�ŧiserver socket
	private List<ConnectionThread> connections = new ArrayList<ConnectionThread>();	//�ŧiclient��array list
	private Random random = new Random();	//�ŧiRandom
	private String [] ans = new String[2];	//�ŧi�@�}�C�ΨӰO��client�Ǧ^������
	public Server(int portNum) {	//����l�Ƥ��ʧ@
		for(int i=0;i<51;i++) check[i]=0;	
		num = 0;
		Index = 0;
		ansnum = 0;
		try {
			this.serverSocket = new ServerSocket(portNum);	//�Ф@server socket�ó]�wport number
			System.out.printf("Server started !\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void sendindex(){	//��method�����ͤ@�������ܼơA�çQ��send message�ǰe�n�ϥΤ��Ϥ�index��client
		Index = random.nextInt(51);
		while(check[Index]==1) Index = random.nextInt(51);
		check[Index]=1;
		/*
		connections.get(0).sendMessage(Integer.toString(Index));	//���O�Nindex���ȶǵ�client
		connections.get(1).sendMessage(Integer.toString(Index));*/
	}
	public void runForever() {	//�����|�@���]��method�A�Ψӱ���client�s�u
		System.out.println("Server starts waiting for client.");
		boolean notready = true;	
		while(true){
			try{
				Socket connectionToClient = this.serverSocket.accept();	//�Yclient�s�u��server�A�h�|accept
				System.out.println("Server is connect!");	//�L�X�@��server�B��client����T
				System.out.println("Player"+(num+1)+"'s host name is 127.0.0.1");
				System.out.println("Player"+(num+1)+"'s IP Address is "+connectionToClient.getInetAddress());
				if(num==0) System.out.println("Server is waiting for client.");	
				ConnectionThread connThread = new ConnectionThread(connectionToClient);	//���C�@��client�s�Ф@��thread�A�����i���q
				connThread.start();	//��connect thread�}�l
				connections.add(connThread);	//�[��}�C���A��K�޲z
				num++;	//num�N��s�u��client��
				System.out.println("Server.num =  "+num);
				if(num>=2 && notready){	//�Y�s�u��client�Ƥj�󵥩��ӡA�h�C���}�l
					sendindex();	//�Nindex�ǰe��client
					connections.get(0).sendMessage("ready");	//�ñN�}�l����T�ǵ��C��client
					connections.get(1).sendMessage("ready");
					notready = false;
				}
			}catch(BindException e){
				//e.printStackTrace();
			}catch(IOException e){
				//e.printStackTrace();
			}
		}
	}
	
	class ConnectionThread extends Thread{	//����connect thread�A���@inner class
		private Socket socket;	//�ŧi�|�Ψ줧�ܼ�
		private BufferedReader reader;
		private PrintWriter writer;
		
		public ConnectionThread(Socket socket){	//constructor
			this.socket = socket;
			try{
				this.writer = new PrintWriter(new 		///writer �ΨӶǰT����client
						OutputStreamWriter(this.socket.getOutputStream()));
				this.reader = new BufferedReader(new	///reader �Ψӱ���client���T��
						InputStreamReader(this.socket.getInputStream()));
			}catch(IOException e){
				//e.printStackTrace();
			}
		}
		public void run(){	
			while(true){	//���_�ʵ�client�ݦ��S���ǰe�T����
				String line;
 				try {
					line = this.reader.readLine();	//�Y���ǰT���ӡA�h�|Ū��line��
					
					if(line.equals("menupress")){
						System.out.println("Server : " + line);
						connections.get(0).sendMessage("char");	//�öǰesolve���T����client
						//connections.get(1).sendMessage("char");
					}
					/*ans[ansnum] = new String(line);	//�Nclient�ǰe�����ץ[��}�C��
					ansnum++;	//�üW�[�ǰe�Ӫ����׭Ӽ�
					if(ansnum>=2){	//�Y���Ҷǰe���סA �h�}�l���
						if(ans[0].equals(ans[1])){	//�Y�@�ˡA�h�N��ѨM�F
							Server.this.sendindex();	//�N�U�@�D��index�ǵ�client
							connections.get(0).sendMessage("solve");	//�öǰesolve���T����client
							connections.get(1).sendMessage("solve");
						}else{	//�Y�����ܡA�h�ǰewrong���r�˵�client
							connections.get(0).sendMessage("wrong");
							connections.get(1).sendMessage("wrong");
						}
						ansnum = 0;
					}*/
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
		public void sendIndex(int num){	//���ǰeindex��client��method
			this.writer.print(num);
			this.writer.flush();
		}
		public void sendMessage(String message){ //���ǰe�T����client��method
			this.writer.println(message);
			this.writer.flush();
		}
	}
	public static void main(String[] args) {
		Server server = new Server(8000);
		server.runForever();
	}
	
}