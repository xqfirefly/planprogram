package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 飞机项目中所有与飞机有关的物体的父类
 * 导包：
 * @author Administrator
 *
 */
public class PlantObject implements Drawable,Moveable{
	
	public int x;
	public int y;
	public Image img; 
	
	public void move(){
		
		
	}
	public void draw(Graphics g){
		g.drawImage(img,x,y,null);
	}

}
