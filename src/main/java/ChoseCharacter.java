package main.java;

import processing.core.PImage;

public class ChoseCharacter{
	private int whichcharacter ;
	private PImage photo ;
	private MainApplet applet;
	private int index ;
	private int x,y ;
	public ChoseCharacter(MainApplet applet,PImage photo,int index){
		this.photo = photo;
		this.applet = applet;
		this.index = index ;
	}
	public void display(){
		this.applet.image(this.photo,this.x,this.y);
	}
	public int getindex(){
		return this.index ;
	}
	public void setx(int x ){
		this.x = x ;
	}
	public void sety(int y ){
		this.y = y ;
	}

}
