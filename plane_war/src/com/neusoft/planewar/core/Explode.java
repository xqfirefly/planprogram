package com.neusoft.planewar.core;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Images;

public class Explode extends PlantObject{
	
	
	
	int step = 0;
	
	public boolean live = true;
	  
	public PlaneWarSystem pws;
	public boolean isLive(){
		return live;
	}
	public void setLive(boolean live){
		this.live = live;
	} 
	
	public static Image[] imgs = {
			
	
			Images.imgs.get("e1"),
			Images.imgs.get("e2"),
			Images.imgs.get("e3"),
			Images.imgs.get("e4"),
			Images.imgs.get("e5"),
	};
	
	
	public Explode(){
		
	}
	public Explode(int x,int y,PlaneWarSystem pws){
		this.x = x;
		this.y = y;
		this.pws = pws;
	}
	
	
	public void draw(Graphics g){
		if(!live){
			pws.explodes.remove(this);
			return;
		}
		if(step>imgs.length-1){
			step = 0;
			live = false;
			return;
		}
		//
		
		g.drawImage(imgs[step],x-imgs[step].getWidth(null)/5,y-imgs[step].getHeight(null)/3,null);
		step++;
		
	}

}
