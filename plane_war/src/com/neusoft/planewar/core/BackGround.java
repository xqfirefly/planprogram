package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.constant.Images;

public class BackGround extends PlantObject{
	public int speed = Constant.GAME_BG_OB_SPEED;
	int y1 = 0;
	int x = 0;
	int y2 = -700;
	public PlaneWarSystem pws;
	
	public static Image[] bgs = {
		Images.imgs.get("bg"),
		Images.imgs.get("bg")
	} ;
	public BackGround(){
		
	}
	public void draw(Graphics g){
		g.drawImage(bgs[0],x,y1,null);
		g.drawImage(bgs[1],x,y2,null);
		move();
	}
	public void move(){
		if(y1>Constant.GAME_HEIGHT){
			y1 =-Constant.GAME_HEIGHT/30*29;
		}
		if(y2>Constant.GAME_HEIGHT){
			y2 =-Constant.GAME_HEIGHT/30*29;
		}
		y1 += speed;
		y2 += speed;
	}

}
