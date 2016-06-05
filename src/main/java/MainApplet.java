package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import controlP5.ControlP5;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.KeyEvent;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	private final static int width = 1400, height = 714;  
	private ArrayList<Character> characters;  
	private ControlP5 cp5;					
	public PImage photo,confirm;
	private ArrayList<ChoseCharacter> character;
	private int whichchar = 0 ;
	private boolean shoot;
	private Bullet bullet;
	
	private Dirction dirction;
	private Power character_power;

	public void setup() {				
		size(width, height);           
		size(1423, 714);
		character = new ArrayList<ChoseCharacter>();
		for (int i = 1 ;i <=8;i++){
			character.add(new ChoseCharacter(this,loadImage(i+"_big.png"),i));
		}
		cp5 = new ControlP5(this);
		cp5.addButton("buttonA").setLabel("Attack").setPosition(8*width/10, 1*height/10).setSize(200, 50); // ��l�ƥ��[�����s
		smooth();
		loadData();
		Ani.init(this);  
		shoot = false;
		bullet = new Bullet(this,loadImage("bullet.png"),200,300,50);
		
		dirction = new Dirction(this,200,200,250,200);
		character_power = new Power(this);
	}

	public void draw() {   
		if(Client.ready == 0){
			background(255,255,255) ;
			for (ChoseCharacter character_:character){   
				character_.display();	
			}
			textSize(60);
			fill(255,0,0); 
		}
		else {
			background(255,255,255);
			bullet.display(shoot);
			
			dirction.display();
			character_power.display();
			if (dirction.get_state() == 1) {
				dirction.turn();
			}
			if (character_power.get_state() == 1) {
				character_power.addpower();
			}
		}
	}
	public void mouseMoved(){    
		int mousex = mouseX ;    
		int mousey = mouseY ;
		
	}
	public void mousePressed() { 
		int mousex = mouseX ;   
		int mousey = mouseY ;
		
		character_power.set_state(1);
		
    }
	public void mouseDragged(){    
		
	}
	public void mouseReleased(){   // ������ƹ��񱼮�   �Ӫ��󦳨S���b �k�䪺�j���W
		character_power.set_state(0);
	}
	public void keyPressed(KeyEvent e){  // �������U �Ʀr 1~7 ��  �i�H�̧ǧ令 star wars�� json 1~7 
		if(Client.ready == 0){
			if(keyCode == UP){
				if(whichchar>3){
					character.get(whichchar).setthis(false);
					whichchar-=4 ;
					character.get(whichchar).setthis(true);
				}
			}
			if(keyCode == DOWN){
				if(whichchar<4){
					character.get(whichchar).setthis(false);
					whichchar+=4 ;
					character.get(whichchar).setthis(true);
				}
			}
			if(keyCode == LEFT){
				if(whichchar>0){
					character.get(whichchar).setthis(false);
					whichchar-- ;
					character.get(whichchar).setthis(true);
				}
			}
			if(keyCode == RIGHT){
				if(whichchar<7){
					character.get(whichchar).setthis(false);
					whichchar ++ ;
					character.get(whichchar).setthis(true);
				}
			}
		}
		else {
			if (e.getKeyCode() == 49) {
				dirction.set_state(1);
			}
			else if (e.getKeyCode() == 50) {
				dirction.set_state(0);
			}
			else if (e.getKeyCode() == 51) {
				character_power.set_vx(character_power.get_power()  * cos(dirction.get_angle()));
				character_power.set_vy(character_power.get_power()  * sin(dirction.get_angle()));
				//印出角度、力量、x方向速度、y方向速度
				System.out.println(dirction.get_angle());
				System.out.println(character_power.get_power());
				System.out.println(character_power.get_vx());
				System.out.println(character_power.get_vy());
				//go_state = 1;
			}
		}
	}
	private void loadData(){   // Ū����� 
		int chx , chy ;
		chx =10;chy=10;
		for (int i = 0 ;i < character.size();i++){
			character.get(i).setx(chx);
			character.get(i).sety(chy);
			chx+=220 ;
			if(i==3){
				chy+=350;
				chx = 10 ;
			}
		}
	}
	public void buttonA(){
		bullet.setPath(character_power.get_vx(),character_power.get_vy());
		shoot = true;
	}
}
