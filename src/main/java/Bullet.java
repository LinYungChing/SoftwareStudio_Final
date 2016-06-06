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
public class Bullet {  // ��class�i�H�N����ܥX���C�@�Ӥp���N�O�@��character,�]�N�O�@��object
	private MainApplet parent;   // �o��ŧi�C�@�Ӫ���ҷ|�Ψ�λݭn�Ψ쪺�ܼ�
	private float x , y ;  // x,y�O�U�C�Ӫ����U��x�y�ХH��y�y��
	private float init_x,init_y;
	private float radius,div;
	private PImage photo;
	private float point_x[],point_y[];
	private int index;
	public Bullet(MainApplet parent,PImage photo,float x ,float y,float radius){  // ��l�ƨC�@�Ӫ���
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
	public void setX(float x){  // �i�H�Y�ɳ]�w������x�y��
		this.x = x;
	}
	public void setY(float y){  // �i�H�Y�ɳ]�w������y�y��
		this.y = y;
	}
	public float getX(){   // �i�H���o�����󪺷�Uy�y��
		return x ;
	}
	public float getY(){  // �i�H���o�����󪺷�Uy�y��
		return y ;
	}
	public void setImage(PImage photo){
		this.photo = photo;
	}
	public void display(boolean shoot){   // ��ܥX���� �n��ܪ��F��
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
	public void setPath(float vx,float vy){
		float time=0;
		float total_time = (float) ((vy*2)/9.8);
		div = total_time/100;
		for(int i=0;i<100;i++){
			point_x[i] = (vx*time);
			point_y[i] = (float) (vy*time+ 0.5*-9.8*time*time);
			time += div;
		}
	
	}
}
