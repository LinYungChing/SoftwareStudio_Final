package main.java;

import processing.core.PImage;

public class StoreItem {
	private boolean inCenter;
	private float x, y;
	private PImage image;
	private int width, height;
	private int grade;
	private int maxGrade = 5;
	public StoreItem(PImage photo, int width, int height) {
		this.image = photo;
		this.width = width;
		this.height = height;
		this.grade = 0;
	}
	public void setX(float x){
		this.x = x;
	}
	public float getX() {
		return this.x;
	}
	public void setY(float y){
		this.y = y;
	}
	public float getY() {
		return this.y;
	}
	public void setInCenter(boolean t){
		inCenter = t;
	}
	public boolean getInCenter(){
		return inCenter;
	}
	public PImage getImage(){
		return image;
	}
	public void setWidth(int w){
		this.width = w;
	}
	public int getWidth() {
		return this.width;
	}
	public void setHeight(int h){
		this.height = h;
	}
	public int getHeight(){
		return this.height;
	}
	public int getGrade(){
		return this.grade;
	}
	public void setGrade(int g){
		this.grade = g;
	}
	public int getMaxGrade(){
		return this.maxGrade;
	}
}
