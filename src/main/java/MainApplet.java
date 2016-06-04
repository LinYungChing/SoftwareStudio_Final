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
	private String file = "src/main/resources/starwars-episode-1-interactions.json"; // ��J�nŪ�J��json�ɮ׸��|
	private String msg = "Star Wars 1" ;   // �]�m����������r  ��r�N��{�b�OŪ�Jstar wars �����@��
	private final static int width = 1400, height = 714;  // �]�m�����j�p 
	
	JSONObject data ;  //data �Ψ� loadJSONObject(���P��json�ɮ�) ;
	JSONArray nodes ,links;   // ��JSONArray �Ψ��x�sjson�ɮ׸̭������P�}�C 
	private int[] inside = new int[50];
	private int index;  
	private float angle,perangle,numOfcircle;  //�����k��j��ΤW���X�Ӫ��� �����C�Ӫ��󪺬۹j����
	private ArrayList<Character> characters;  // ���}�C�O�U json��nodes�}�C�����Ҧ����
	private ArrayList<Character> targets ;   //  ���}�C�O�Ujson��links�}�C�����Ҧ����
	private ControlP5 cp5;					// ���s
	
	public PImage photo,confirm;
	private ArrayList<ChoseCharacter> character;
	private int whichchar = 0 ;
	public void setup() {				// �Ҧ��Ȫ���l��
		size(width, height);           // �]�m�����j�p
		
		
		
		size(1423, 714);
		character = new ArrayList<ChoseCharacter>();
		for (int i = 1 ;i <=8;i++){
			character.add(new ChoseCharacter(this,loadImage(i+"_big.png"),i));
		}
		smooth();
		loadData();
		Ani.init(this);  // initial�ʵe
	}

	public void draw() {   // ��class�|�@������  �@����s����
		if(Client.ready == 0){
			background(255,255,255) ;
			for (ChoseCharacter character_:character){   
				character_.display();	// ��ܥX�C�Ӫ���
			}
			textSize(60);
			fill(255,0,0); // �]�m�r���C��
			text("SELECT", 3*width/4, height/8);  // ��ܥX�r ����r�O�b�����̤��� �ΨӪ�ܲ{�b�Ostar war���ĴX��
			text("Characters", 3*width/4, height/4);
		}
		else {
			
		}
	}
	public void mouseMoved(){    // ��class �Φb  ��ƹ������ʮ�  ��class�i�H�����ƹ����ʮy�� �Y�ƹ��b����W �h��ܥX���󪺦r
		int mousex = mouseX ;    // �O���U�ƹ����ʮɪ���U�y��
		int mousey = mouseY ;
		
	}
	public void mousePressed() { // ��class�����P�W�zmouseMoved()  ��ƹ����U����� �Y���b����W �h�i�H�}�l��Ԫ��󲾰�
		int mousex = mouseX ;   //�O�U��U�ƹ���xy�y��
		int mousey = mouseY ;
		
    }
	public void mouseDragged(){    // �ƹ����U��쪺�L�{
		if(characters.get(index).enable){   // �Y���ƹ������b����W
			characters.get(index).setX(mouseX);   // �h�ƹ����ʨ���� �h�Ӫ��󪺮y�дN�|�ήɧ�s �H�۷ƹ��ܰ�
			characters.get(index).setY(mouseY);
		}
	}
	public void mouseReleased(){   // ������ƹ��񱼮�   �Ӫ��󦳨S���b �k�䪺�j���W
		
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
}
