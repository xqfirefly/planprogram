package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Images;

public class Start extends PlantObject{
	public PlaneWarSystem pws;
	int x=0;
	public int y=0;
	
	
	public void draw(Graphics g){
		
			g.drawImage(Images.imgs.get("start"), x,y,null);
			move();
		}
	public void move(){
		y+=5;
	}
	

}
