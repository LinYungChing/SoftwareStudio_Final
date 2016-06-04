package main.java;
//import main.java.MainApplet;
//import processing.core.PApplet;

public class Dirction {
	private float x1,y1,x2,y2,num;
	private int state,dir;
	private MainApplet parent;
	
	public Dirction(MainApplet parent, float x1, float y1, float x2, float y2) {
		this.parent = parent;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		state = 0;
		num = 0;
		dir = 0;
	}
	
	public void display() {
		this.parent.line(x1, y1, x2, y2);
	}
	
	public void turn(){
		x2 = (float) (200 + 50 * Math.cos((float) (num)));
		y2 = (float) (200 - 50 * Math.sin((float) (num)));
		
		if (dir == 1 && num > 1.57) {
			dir = 0;
		}
		else if (dir == 0 && num < 0.02) {
			dir = 1;
		}
		
		if (dir == 1) {
			num = (float) (num + 0.01);
		}
		else {
			num = (float) (num - 0.01);
		}
	}
	
	public void set_state(int i) {
		this.state = i;
	}
	
	public int get_state() {
		return this.state;
	}
	
	public float get_angle() {
		return num;
	}
}
