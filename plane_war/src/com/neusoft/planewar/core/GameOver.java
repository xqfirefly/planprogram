package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.constant.Images;

public class GameOver extends PlantObject{
	int step = 0;
	
	public PlaneWarSystem pws;
	
	public Image[] imgs = {
			Images.imgs.get("g1"),
			Images.imgs.get("g2"),
			Images.imgs.get("g3"),
			Images.imgs.get("g4"),
			Images.imgs.get("g5"),
			Images.imgs.get("g5"),
			Images.imgs.get("g6"),
			Images.imgs.get("g7"),
			Images.imgs.get("g8"),
			Images.imgs.get("g9"),
			
	};
	public GameOver(){
		
	}
	public GameOver(PlaneWarSystem pws){
		this.x = Constant.GAME_WIDHT/2 - imgs[0].getWidth(null)/2;
		this.y = Constant.GAME_HEIGHT/2 - imgs[0].getHeight(null)/2-100;
		this.pws = pws;
	}

	public void draw(Graphics g){
		
			if(step>imgs.length-1){ 
				step = 0;
			}
			g.drawImage(imgs[step], x, y,null);
			step++;
		}

}
