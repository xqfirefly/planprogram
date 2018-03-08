package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.constant.Images;

public class Obstruction extends PlantObject{
	public PlaneWarSystem pws;
	public int speed = Constant.GAME_BG_OB_SPEED;
	int width;
	int height;
	
	public int Life = 500;
	
	public int getLife() {
		return Life;
	}

	public void setLife(int life) {
		Life = life;
	}

	public Obstruction(PlaneWarSystem pws){
		this.x = 100;
		this.y = -200;
		this.img = Images.imgs.get("muxing");
		this.pws = pws;
	}
	
	public Obstruction(int x,int y,int width,int height,PlaneWarSystem pws){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height =height;
		
		this.pws = pws;
	}
	
	public void draw(Graphics g){ 
		if(this.getLife()>0){
		//g.drawImage(img,x,y,null);
		g.fillRect(x,y,width,height);
		move();
		}
	}
	public void move(){
		y +=speed;
	}
	public Rectangle getRect(){
		return new Rectangle(x,y,width,height);
	}

}
