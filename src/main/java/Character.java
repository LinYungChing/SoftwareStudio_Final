package main.java;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {  // ��class�i�H�N����ܥX���C�@�Ӥp���N�O�@��character,�]�N�O�@��object
	
	public MainApplet parent;   // �o��ŧi�C�@�Ӫ���ҷ|�Ψ�λݭn�Ψ쪺�ܼ�
	public float x , y ;  // x,y�O�U�C�Ӫ����U��x�y�ХH��y�y��
	public boolean enable; // enable == 1 ��ܷƹ������b������W
	public int hi ;   // hi �������C��
	private String name ;  // name�O �����󪺦W��
	private int show = 0 ;  // show = 1 �����ܥX�����󪺦r,��ƹ��b������W��show�~�|=1 �B�|��ܥX������name 
	
	public Character(MainApplet parent,float x ,float y ,int hi,String name){  // ��l�ƨC�@�Ӫ���
		this.parent = parent;
		this.x = x ;
		this.y = y ;
		this.hi = hi ;
		this.name = name ;
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
	public void setEnable(boolean x){ // ��ƹ����U����� �B ���U��m�b����W�� �h���ɦ�����setenable�|�O1
		this.enable = x;
	}
	public void show(){  // ��ƹ����ʨ즹����W�� �|��������show == 1   �hdisplay�ɷ|��ܥX�Ӫ��󪺦W��
		this.show = 1 ;
	}
	public void notshow(){   // ��ƹ����ʮ� �B�ƹ���U�S���u����󪫥� �hshow=0 ���|��ܥX ����W��
		this.show = 0 ;
	}
	public void display(){   // ��ܥX���� �n��ܪ��F��
		this.parent.fill(hi);   // �[�J���Ӫ����C��
		this.parent.ellipse(x,y,40,40); // �N�C�Ӫ�����ܦ����
		if(show == 1){  // ��show == 1 ��  �h�N��ƹ��b����W 
			this.parent.text(name, x+40, y+40); // �h�|��ܥX���󪺦r
		}
	}
}
