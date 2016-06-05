package main.java;

import java.awt.Color;
import java.util.ArrayList;

import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PImage;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Bullet {  // 此class可以代表顯示出的每一個小圈圈就是一個character,也就是一個object
	private MainApplet parent;   // 這邊宣告每一個物件所會用到及需要用到的變數
	private float x , y ;  // x,y記下每個物件當下的x座標以及y座標
	private float init_x,init_y;
	private float radius,div;
	private PImage photo;
	private float point_x[],point_y[];
	private int index;
	public Bullet(MainApplet parent,PImage photo,float x ,float y,float radius){  // 初始化每一個物件
		this.parent = parent;
		this.photo = photo;
		this.x = x ;
		this.y = y ;
		this.radius = radius;
		this.init_x = x;
		this.init_y = y;
		this.point_x = new float[100];
		this.point_y = new float[100];
	}
	public void setX(float x){  // 可以即時設定此物件的x座標
		this.x = x;
	}
	public void setY(float y){  // 可以即時設定此物件的y座標
		this.y = y;
	}
	public float getX(){   // 可以取得此物件的當下y座標
		return x ;
	}
	public float getY(){  // 可以取得此物件的當下y座標
		return y ;
	}
	public void setImage(PImage photo){
		this.photo = photo;
	}
	public void display(boolean shoot){   // 顯示出物件 要顯示的東西
		if(shoot){
			if(index<99){
				this.parent.image(this.photo,x,y);
				Ani.to(this,div, "x",(float)(init_x+point_x[index]));
				Ani.to(this,div, "y",(float)(init_y-point_y[index]));
			}
			else{
				this.parent.ellipse(x, y, radius*2, radius*2);
				this.parent.fill(155);
				Ani.to(this, (float)2, "radius",200,Ani.LINEAR);
			}
			if(index<99)index++;
		}
	}
	public void setPath(float speed,float angle){
		float time=0;
		float total_time = (float) ((speed*angle*2)/9.8);
		div = total_time/100;
		for(int i=0;i<100;i++){
			point_x[i] = (speed*angle*time);
			point_y[i] = (float) (speed*angle*time+ 0.5*-9.8*time*time);
			time += div;
		}
	
	}
}
