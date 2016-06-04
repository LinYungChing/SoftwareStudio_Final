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
	private String path = "main/resources/";
	private String file = "src/main/resources/starwars-episode-1-interactions.json"; // 放入要讀入的json檔案路徑
	private String msg = "Star Wars 1" ;   // 設置視窗中的文字  文字代表現在是讀入star wars 的哪一集
	private final static int width = 1400, height = 714;  // 設置視窗大小 
	
	JSONObject data ;  //data 用來 loadJSONObject(不同的json檔案) ;
	JSONArray nodes ,links;   // 此JSONArray 用來儲存json檔案裡面的不同陣列 
	private int[] inside = new int[50];
	private int index;  
	private float angle,perangle,numOfcircle;  //紀錄右邊大圓形上有幾個物件 紀錄每個物件的相隔角度
	private ArrayList<Character> characters;  // 此陣列記下 json中nodes陣列中的所有資料
	private ArrayList<Character> targets ;   //  此陣列記下json中links陣列中的所有資料
	private ControlP5 cp5;					// 按鈕
	
	public PImage photo,confirm;
	private ArrayList<ChoseCharacter> character;
	private int whichchar = 0 ;
	public void setup() {				// 所有值的初始化
		size(width, height);           // 設置視窗大小
		
		
		
		size(1423, 714);
		character = new ArrayList<ChoseCharacter>();
		for (int i = 1 ;i <=8;i++){
			character.add(new ChoseCharacter(this,loadImage(i+"_big.png"),i));
		}
		smooth();
		loadData();
		Ani.init(this);  // initial動畫
	}

	public void draw() {   // 此class會一直執行  一直刷新視窗
		if(Client.ready == 0){
			background(255,255,255) ;
			for (ChoseCharacter character_:character){   
				character_.display();	// 顯示出每個物件
			}
			textSize(60);
			fill(255,0,0); // 設置字的顏色
			text("SELECT", 3*width/4, height/8);  // 顯示出字 此文字是在視窗最中間 用來表示現在是star war的第幾集
			text("Characters", 3*width/4, height/4);
		}
		else {
			
		}
	}
	public void mouseMoved(){    // 此class 用在  當滑鼠有移動時  此class可以偵測滑鼠移動座標 若滑鼠在物件上 則顯示出物件的字
		int mousex = mouseX ;    // 記錄下滑鼠移動時的當下座標
		int mousey = mouseY ;
		
	}
	public void mousePressed() { // 此class概念同上述mouseMoved()  當滑鼠按下按鍵時 若有在物件上 則可以開始拖拉物件移動
		int mousex = mouseX ;   //記下當下滑鼠的xy座標
		int mousey = mouseY ;
		
    }
	public void mouseDragged(){    // 滑鼠按下後拖的過程
		if(characters.get(index).enable){   // 若此滑鼠按壓在物件上
			characters.get(index).setX(mouseX);   // 則滑鼠移動到哪裡 則該物件的座標就會及時更新 隨著滑鼠變動
			characters.get(index).setY(mouseY);
		}
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
}
