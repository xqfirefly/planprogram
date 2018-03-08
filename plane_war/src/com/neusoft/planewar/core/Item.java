package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Images;

public class Item extends PlantObject{
	
	public PlaneWarSystem pws;
	
	public int category;
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public boolean live;
	
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	
	public Image[] imgs = {
			Images.imgs.get("blood"),
			Images.imgs.get("allexplode"),
			Images.imgs.get("plane_small"),
			Images.imgs.get("planechange"),
	};
	
	
	public Item(int x,int y,PlaneWarSystem pws,int category){
		this.pws = pws;	
		this.x = x;
		this.y = y;
		this.live = true;
		this.category = category;
		this.img = imgs[category];
		
	}
	public void draw(Graphics g){
		if(!live){
			pws.bloods.remove(this);
			return;
		}else{
			g.drawImage(img,x,y,null);
			move();
		}
	}
	public void move(){
		 y += 3;
	}
	/**
	 * Åö×²¼ì²â
	 */
	public Rectangle getRect(){
		return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
	}

}
