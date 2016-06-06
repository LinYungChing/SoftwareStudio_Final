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
	private Store store;

	public void setup() {				
		size(width, height);           
		size(1423, 714);
		character = new ArrayList<ChoseCharacter>();
		for (int i = 1 ;i <=8;i++){
			character.add(new ChoseCharacter(this,loadImage(i+"_big.png"),i));
		}
		cp5 = new ControlP5(this);
		cp5.addButton("buttonA").setLabel("Attack").setPosition(8*width/10, 1*height/10).setSize(200, 50); // 初始化全加的按鈕
		cp5.addButton("buttonStore").setLabel("Store").setPosition(8*width/10, 1*height/10+100).setSize(200, 50); 
		smooth();
		loadData();
		Ani.init(this);  
		shoot = false;
		bullet = new Bullet(this,loadImage("bullet.png"),200,300,50);
		store = new Store(this);
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
		}
		store.display(store.getInStore());
	}
	public void mouseMoved(){    
		int mousex = mouseX ;    
		int mousey = mouseY ;
		
	}
	public void mousePressed() { 
		int mousex = mouseX ;   
		int mousey = mouseY ;
		
    }
	public void mouseDragged(){    
		
	}
	public void mouseReleased(){   // 偵測當滑鼠放掉時   該物件有沒有在 右邊的大圓圈上
		
	}
	public void keyPressed(KeyEvent e){  // 當按鍵按下 數字 1~7 時  可以依序改成 star wars的 json 1~7 
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
			
		}
	}
	private void loadData(){   // 讀取資料 
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
		bullet.setPath((float)50, (float)1.2);
		shoot = true;
	}
	public void buttonStore(){
		if(!store.getInStore())
			store.reset();
		store.setInStore(true);
	}
	public void buttonBack() {
		store.setInStore(false);
	}
	public void buttonLeft() {
		store.pushLeft();
	}
	public void buttonRight() {
		store.pushRight();
	}
	public void buttonUpgrade() {
		store.pushUpgrade();
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
