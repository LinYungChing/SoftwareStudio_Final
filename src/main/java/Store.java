package main.java;

import java.awt.Color;
import java.util.ArrayList;

import controlP5.Button;
import controlP5.ControlP5;
import controlP5.Controller;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
public class Store{
	private MainApplet parent;
	private int centerX = 450, centerY = 200, gap = 150;
	private float x = centerX, y = centerY;
	private float itemWidth = 140, itemHeight = 180;
	private int firstItem = 0, lastItem = 2, firstMoney = 0, lastMoney = 5, firstGrade = 0, lastGrade = 5;
	private ArrayList<StoreItem> item, money, grade;
	private StoreItem store;
	private boolean inStore = false;
	private ControlP5 cp5;
	public Store(MainApplet parent){
		this.parent = parent;
		item = new ArrayList<StoreItem>();
		money = new ArrayList<StoreItem>();
		grade = new ArrayList<StoreItem>();
		for(int i=0; i<lastMoney+1; i++){
			PImage photo = this.parent.loadImage("money"+ i + ".png");
			money.add(new StoreItem(photo, photo.width, photo.height));
		}
		for(int i=0; i<lastItem+1; i++) {
			PImage photo = this.parent.loadImage("item" + i + ".png");
			item.add(new StoreItem(photo, photo.width, photo.height));
		}
		for(int i=0; i<lastGrade+1; i++) {
			PImage photo = this.parent.loadImage("grade" + i + ".png");
			grade.add(new StoreItem(photo, photo.width, photo.height));
		}
		int tmp = 0;
		for(StoreItem i : item){
			i.setX(x);
			i.setY(y);
			x += gap;
			if(tmp == firstItem) {
				i.setInCenter(true);
			}
			tmp++;
		}
		for(StoreItem m : money){
			m.setX(centerX - 100);
			m.setY(7*parent.getHeight()/10 - 60);
		}
		for(StoreItem g : grade){
			g.setX(centerX + 100);
			g.setY(7*parent.getHeight()/10);
		}
		PImage photo = parent.loadImage("store.png");
		store = new StoreItem(photo, photo.width, photo.height);
		store.setX(0);
		store.setY(0);
		this.cp5 = new ControlP5(this.parent);
		this.cp5.addButton("buttonBack")
		   	.setLabel("Back")
		   	.setPosition(8*parent.getWidth()/10, 9*parent.getHeight()/10-50)
		   	.setSize(200, 50);
		this.cp5.addButton("buttonLeft")
			.setLabel("Left")
			.setPosition(1*parent.getWidth()/10, 8*parent.getHeight()/10)
			.setSize(100, 50);
		this.cp5.addButton("buttonRight")
			.setLabel("Right")
			.setPosition(6*parent.getWidth()/10, 8*parent.getHeight()/10)
			.setSize(100, 50);
		this.cp5.addButton("buttonUpgrade")
			.setLabel("Upgrade")
			.setPosition(3*parent.getWidth()/10, 8*parent.getHeight()/10)
			.setSize(200, 50);
	}
	public void display(boolean t){
		if(t){	
			parent.background(255,255,255);
			parent.image(store.getImage(), 0, 0, 1000, 700);
			for(StoreItem i : item){
				if(i.getInCenter()){
					parent.image(i.getImage(), i.getX(), i.getY(), itemWidth*7/5, itemHeight*7/5);
					if(i.getGrade() <= i.getMaxGrade()){
						int tmp = 0;
						for(StoreItem m : money){
							if(tmp == i.getGrade()){
								parent.image(m.getImage(), m.getX(), m.getY(), 150, 100);
								break;
							}
							tmp++;
						}
						tmp = 0;
						for(StoreItem g : grade){
							if(tmp == i.getGrade()){
								parent.image(g.getImage(), g.getX(), g.getY(), g.getWidth(), g.getHeight());
								break;
							}
							tmp++;
						}
					} else {
						int tmp = 0;
						for(StoreItem m : money){
							if(tmp == i.getMaxGrade()){
								parent.image(m.getImage(), m.getX(), m.getY(), 150, 100);
								break;
							}
							tmp++;
						}
						tmp = 0;
						for(StoreItem g : grade){
							if(tmp == i.getMaxGrade()){
								parent.image(g.getImage(), g.getX(), g.getY(), g.getWidth(), g.getHeight());
								break;
							}
							tmp++;
						}
					}
				}
				else
					parent.image(i.getImage(), i.getX(), i.getY(), itemWidth, itemHeight);
					
				
			}
			cp5.setVisible(true);
		} else {
			cp5.setVisible(false);
		}
	}
	public boolean getInStore() {
		return inStore;
	}
	public void setInStore(boolean t){
		inStore = t;
	}
	public void pushLeft(){
		int tmp = 0;
		for(StoreItem i : item){
			if(tmp == firstItem && i.getX() == centerX)
				break;
			if(i.getInCenter())
				i.setInCenter(false);
			i.setX(i.getX() + gap);
			if(i.getX() == centerX)
				i.setInCenter(true);
			tmp++;
		}
	}
	public void pushRight(){
		int tmp = 0;
		for(StoreItem i : item){
			if(tmp == lastItem && i.getX() == centerX)
				return ;
			tmp++;
			
		}
		for(StoreItem i : item){
			if(i.getInCenter())
				i.setInCenter(false);
			//Ani.to(this, 2, "x",(float)(i.getX() - gap));
			i.setX(i.getX() - gap);
			if(i.getX() == centerX)
				i.setInCenter(true);
		}
	}
	public void pushUpgrade() {
		for(StoreItem i : item) {
			if(i.getInCenter())
				i.setGrade(i.getGrade()+1);
		}
	}
	public void reset() {
		int tmp = centerX;
		for(StoreItem i : item) {
			i.setInCenter(false);
			i.setX(tmp);
			tmp += gap;
		}
		item.get(0).setInCenter(true);
	}
}
