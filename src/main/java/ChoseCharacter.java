package main.java;

import processing.core.PImage;

public class ChoseCharacter{
	private int whichcharacter ;
	private PImage photo ;
	private MainApplet applet;
	private int index ;
	private int x,y ;
	private boolean decide ;
	public ChoseCharacter(MainApplet applet,PImage photo,int index){
		this.photo = photo;
		this.applet = applet;
		this.index = index ;
		this.decide = false ;
	}
	public void display(){
		this.applet.image(this.photo,this.x,this.y);
		if(this.decide == true){
	
		this.applet.line(x-20, y-20, x, y);
		this.applet.strokeWeight(3);
		this.applet.stroke(255,0,0);
		this.applet.line(x, y, x+20, y-20);
		this.applet.strokeWeight(3);
		this.applet.stroke(255,0,0);
		
		}
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
	public void setthis(boolean decide){
		this.decide = decide ;
	}

}
