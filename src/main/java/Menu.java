package main.java;

import controlP5.ControlP5;
import processing.core.PImage;

public class Menu {
	private MainApplet parent ;
	private PImage photo ;
	private ControlP5 button ;
	private boolean buttondown ;
	public Menu (MainApplet parent, PImage photo){
		this.parent = parent ;
		this.photo = photo ;
		buttondown = false ;
		button = new ControlP5(parent);
		button.addButton("buttonA").setLabel("Change").setPosition(2*parent.getWidth()/10, 1*parent.getHeight()/10).setSize(200, 50); 
	}
	public void display(){
		this.parent.image(photo, 0, 0);
	}
	private String input ;
	private void buttonA(){
		input = "menupress" ;
		System.out.println(input);
		Client.writer.println(input);
		buttondown = true ;
	}
	public boolean press(){
		return  buttondown ;
	}
}
