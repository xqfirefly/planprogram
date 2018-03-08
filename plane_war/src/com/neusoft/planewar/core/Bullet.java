package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.constant.Images;
//import com.neusoft.planewar.constant.Images;
import com.neusoft.planewar.util.GameUtil;

public class Bullet extends PlantObject{
	public Direction dir;
	
	public  int speed = 15;
	
	private boolean live = true;
	
	public PlaneWarSystem pws;
	
	private int c;
	
	public static Random r = new Random();
	
	public boolean good;
	public boolean isGood(){
		return good;
	}
	public void setGood(boolean good){
		this.good = good;
	}
	
	public boolean isLive(){
		return live;
	}
	public void setLive(boolean live){
		this.live = live;
	}																				
	
	
	
	
	
	public  Bullet(int x,int y){
		this.x = x;
		this.y = y;
		this.img = Images.imgs.get("bulletborder");
	}
	public  Bullet(int x,int y,Direction dir){
		this(x,y);
		
		this.dir = dir;
	}
	public  Bullet(int x,int y,Direction dir,PlaneWarSystem pws,boolean good){
		this(x, y,dir);
		
		this.pws = pws;
		this.good = good;
	}
	public  Bullet(int x,int y,Direction dir,PlaneWarSystem pws,boolean good,Image img){
		this(x, y,dir);
		
		this.pws = pws;
		this.good = good;
		this.img = img;
	}
	
	
	public void draw(Graphics g){
		if(!live){
			pws.bullets.remove(this);
			return;
		}
		g.drawImage(img,x,y,null);
		move();
	}
	public void move(){
		switch(dir){
		case LEFT:
			x -= speed;
			break;
		case LEFT_UP:
			x -= speed/1.414;
			y -= speed/1.414;
			break;
		case UP:
			y -= speed;
			break;
		case RIGHT_UP:
			x += speed/1.414;
			y -= speed/1.414;
			break;
		case RIGHT:
			x += speed;
			break;
		case RIGHT_DOWN:
			x += speed/1.414;
			y += speed/1.414;
			break;
		case DOWN:
			y += speed;
			break;
		case LEFT_DOWN:
			x -= speed/1.414;
			y += speed/1.414;
			break;
		default:
			break;
		}
		
		//
		if(x<-100||y<-100||x>Constant.GAME_WIDHT+100||y>Constant.GAME_HEIGHT+100){
			this.live = false;
			this.pws.bullets.remove(this);
			
		}
			
	}
	
	/**
	 * 碰撞检测
	 */
	public Rectangle getRect(){
		return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
	}
	//击打飞机生成爆炸效果
	public boolean hitPlane(Plane p){
		if(this.live&&p.isLive()&&this.getRect().intersects(p.getRect())&&this.good !=p.isGood()){
			if(p.isGood()&&p.isLive()){
				p.setLife(p.getLife()-10);
				//p.img = Images.imgs.get("plane21");
				if(p.getLife()<=0){
					p.setLive(false);

					//生成爆炸
					Explode e = new Explode(p.x,p.y,pws);
					pws.explodes.add(e);
					if(p.getLifeCount()>0){
						p.setLifeCount(p.getLifeCount()-1); 
					}
				}
				pws.bullets.remove(this);
			}else{
			
			this.live = false;
			pws.bullets.remove(this);
			p.setLive(false);
			
			
			if(!p.isGood()){
			//生成爆炸
			Explode e = new Explode(p.x,p.y,pws);
			pws.explodes.add(e);
			//在死了的敌人飞机位置画出血块
			for(int i=0;i<pws.enemyPlanes.size();i++){
				Plane enemyPlane = pws.enemyPlanes.get(i);
				if(!enemyPlane.isLive()){
					if(r.nextInt(4)==0){c=0;}
					if(r.nextInt(4)==1){c=1;}
					if(r.nextInt(4)==2){c=2;}
					if(r.nextInt(4)==3){c=3;}
					if(r.nextInt(7)>1){
						if(c==0){
							Item blood = new Item(enemyPlane.x+enemyPlane.img.getWidth(null)/2-25,enemyPlane.y+enemyPlane.img.getHeight(null)/2,pws,0);
							pws.bloods.add(blood);
						}
						if(c == 1){
							Item blood = new Item(enemyPlane.x+enemyPlane.img.getWidth(null)/2-25,enemyPlane.y+enemyPlane.img.getHeight(null)/2,pws,1);
							pws.bloods.add(blood);
						} 
						if(c==2){
							Item blood = new Item(enemyPlane.x+enemyPlane.img.getWidth(null)/2-25,enemyPlane.y+enemyPlane.img.getHeight(null)/2,pws,2);
							pws.bloods.add(blood);
						}
						if(c==3){
							Item blood = new Item(enemyPlane.x+enemyPlane.img.getWidth(null)/2-25,enemyPlane.y+enemyPlane.img.getHeight(null)/2,pws,3);
							pws.bloods.add(blood);
						}
							
						}
					
				}
				
			}
			pws.enemyPlanes.remove(p);
			}
			}
			
				return true;
				}else{
					return false;
				}
				
	}
	
	public boolean hitPlanes(List<Plane> planes){
		for(int i=0;i<planes.size();i++){
			Plane plane = planes.get(i);
			if(hitPlane(plane)){
				return true;
				}
			}
		return false;
		}
	
	public boolean hitObstruction(Obstruction ob){
		if(this.getRect().intersects(ob.getRect())&&ob.getLife()>0){
			this.live = false;
			ob.setLife(ob.getLife()-Constant.LOSE_BLOOD);
			
				return true;
			
			
		}else{
			return false;
		}
	} 
	public boolean hitObstructions(List<Obstruction> obs){
		for(int i=0;i<obs.size();i++){
			Obstruction ob = obs.get(i);
			if(this.hitObstruction(ob)){
				return true;
			}
		}
		return false;
	}
	
	public void hitBoss(Boss boss){
		if(this.live&&boss.getLife()>0&&this.getRect().intersects(boss.getRect())){
			if(good){
				boss.setLife(boss.getLife()-Constant.BOSS_LOSE_BLOOD);
				if(boss.getLife()<=0){
					Explode e = new Explode(this.x,this.y,pws);
					pws.explodes.add(e);
				}
			}
			
		}
		
	}
	
	public void hitObstructionSelf(Obstruction ob){
		if(this.live&&ob.getLife()>0&&this.getRect().intersects(ob.getRect())){
			
		}
	}
	
}
	

