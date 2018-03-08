package com.neusoft.planewar.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.constant.Images;

public class Boss extends PlantObject{
	public PlaneWarSystem pws;
	 int speed = 2;
	private int life = 1000;
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life){
		this.life = life;
	}
	
	

	public static Random r = new Random();
	public Image[] imgs = {
			Images.imgs.get("boss1"),
			Images.imgs.get("boss2"),
			Images.imgs.get("boss3"),
			Images.imgs.get("boss4"),
			Images.imgs.get("boss5"),
			Images.imgs.get("boss6"),
			Images.imgs.get("boss7"),
			Images.imgs.get("boss8"),
			Images.imgs.get("boss9"),
			
	};
	
	int step = 0;
	
	public boolean right;
	public Boss(){
		
	}
	public Boss(PlaneWarSystem pws){
		this.x = Constant.GAME_WIDHT/2 - imgs[0].getWidth(null)/2;
		this.y = -imgs[0].getHeight(null)/2-100;
		this.pws = pws;
		
	}
	
	
	public Rectangle getRect(){
		return new Rectangle(x,y,imgs[0].getWidth(null),imgs[0].getHeight(null));
	}
	
	public void draw(Graphics g){
		//画出BOSS血条
		bb.draw(g);
		
		if(step>imgs.length-1){
			step = 0;
		}
		if(this.getLife()>0){
		g.drawImage(imgs[step], x, y,null);
		step++;
		move();
		}
	}
	public void move(){
		if(y>85){
			y = 85;
			if(right){
				x += speed;
			}else{
				x -=speed;
			}
			if(x<5){
				right = true;
			}
			if(x>Constant.GAME_WIDHT-imgs[0].getWidth(null)-5){
				right = false;
			}
		}
		y +=speed;
		//BOSS发子弹
		if(r.nextInt(101)>90) fire01();
		if(r.nextInt(101)>98) fire02();
	}
	/**
	 * boss发子弹
	 */
	
	
	public void fire02(){
		Direction[] dirs = Direction.values();
		for(int i=0;i<8;i++){
		Bullet b = new Bullet(x+imgs[0].getWidth(null)/2-15,y+imgs[0].getHeight(null)/2-15,dirs[i],pws,false,Images.imgs.get("bossbullet"));
		pws.bullets.add(b);
		}
	}
	public void fire01(){
		Bullet b = new Bullet(x+imgs[0].getWidth(null)/2-15,y+imgs[0].getHeight(null)/2-10,Direction.DOWN,pws,false,Images.imgs.get("bossbullet"));
		pws.bullets.add(b);
		}
	
	public BloodBar bb = new BloodBar();
	class BloodBar{
		public void draw(Graphics g){
			if(life>0){
			g.drawImage(Images.imgs.get("boss_small"), 10, 45, null);
			Color c = g.getColor();
			
			if(900*life/1000>0.7*900){
				g.setColor(Color.GREEN);
				g.drawRect(80, 48, 900, 42);
				g.fillRect(80, 48, 900*life/1000, 42);
			}else{
				 if(900*life/1000>0.4*900){
					g.setColor(Color.ORANGE);
					g.drawRect(80, 48, 900, 42);
					g.fillRect(80, 48, 900*life/1000, 42);
					}else{
					g.setColor(Color.RED);
					g.drawRect(80, 48, 900,42);
					g.fillRect(80, 48, 900*life/1000, 42);
					}
				 g.setColor(c);
				}
				
			}
		}
	}
	

}
