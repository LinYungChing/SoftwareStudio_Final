package main.java;

public class Power {
	
	private float power,vx,vy,y,v;
	private int state;
	private MainApplet parent;
	
	public Power(MainApplet parent) {
		this.parent = parent;
		power = 0;
		y = 10;
		state = 0;
		vx = 0;
		vy = 0;
		v = 0;
	}
	
	public void display() {
		this.parent.rect(20, 20, power, y);
		this.parent.fill(200,200,200);
		this.parent.rect(20+power, 20, 200-power, y);
		this.parent.fill(255,0,0);
	}
	
	public void set_state(int i) {
		state = i;
	}
	
	public int get_state() {
		return state;
	}
	
	public void set_v(float v) {
		this.v = v;
	}
	
	public void addpower(){
		if (power < 200) {
			power++;
		}
		else{
			power = 0;
		}
	}
	
	public void set_vx(float x) {
		vx = x;
	}
	
	public void set_vy(float y) {
		vy = y;
	}
	
	public float get_power() {
		return power;
	}
	
	public float get_vx() {
		return vx;
	}
	
	public float get_vy() {
		return vy;
	}
}
