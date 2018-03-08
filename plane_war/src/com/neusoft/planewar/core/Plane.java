package com.neusoft.planewar.core;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.constant.Images;
import com.neusoft.planewar.util.GameUtil;

/**
 * ��ݸ��ƣ�ctrl+alt+��
 * �ƶ���ѡ���ݣ�alt+��/��
 * @author Administrator
 *
 */

public class Plane extends PlantObject{
	
	/**
	 * ��ʼ��
	 */
	
	private URL url; 
	private  AudioClip ac;

	
	public int x;
	public int y;
	public Image img;
	public int speed = 8;
	/**
	 * ����ɻ��˶�����ı�����
	 */
	private boolean left,up,right,down;
	
	public boolean good;
	public boolean isGood(){
		return good;
	}
	public void setGood(boolean good){
		this.good = good;
	}
	
	public Direction dir = Direction.DOWN;
	
	public PlaneWarSystem pws;
	
	
	
	private boolean live = true;
	/**
	 * ��¼�ɻ���һ��λ��
	 */
	int preX;
	int preY;
	
	private boolean c;
	
	public int kind;
	
	private int life = 100;
	public int getLife(){
		return life;
	}
	public void setLife(int life){
		this.life = life;
	}
	
	
	public static Random r = new Random();
	public boolean isLive(){
		return live;
	}
	public void setLive(boolean live){
		this.live = live;
	}
	
	public int lifeCount = 0;
	
	
	
	public int getLifeCount() {
		return lifeCount;
	}
	public void setLifeCount(int lifeCount) {
		this.lifeCount = lifeCount;
	}
	public Plane(){
		
	}
	/**
	public Plane(int x,int y,Image img){
		this.x = x;
		this.y = y;
		this.img = img;
	}
	public Plane(int x,int y,String imgPath){
		this.x = x;
		this.y = y;
		this.img = GameUtil.getImage(imgPath);
	}
	public Plane(int x,int y,String imgPath,boolean good){
		this.x = x;
		this.y = y;
		this.img = GameUtil.getImage(imgPath);
		//this.(x,y,imgPath);
		this.good = good;
	}
	public Plane(int x,int y,String imgPath,boolean good,Direction dir){
		
		this(x,y,imgPath,good);
		this.dir = dir;
	}
public Plane(int x,int y,String imgPath,boolean good,PlaneWarSystem pws){
		
		this(x,y,imgPath,good);
		this.pws = pws;
	}
	**/
public Plane(int x,int y,boolean good,PlaneWarSystem pws,int kind){
	
	this.x = x;
	this.y = y;
	this.preX = x;
	this.preY = y;
	this.good = good;
	if(good){
		this.img = Images.imgs.get("myPlane");
		this.lifeCount = 3;
	}else{
		if(kind==1){
			this.img = Images.imgs.get("enemyPlane");
		}
		if(kind==2){
		this.img = Images.imgs.get("planedj2");
		}
		if(kind==3){
			this.img = Images.imgs.get("planedj3");
		}
		//this.dir = Direction.LEFT_DOWN;
	}
	this.pws = pws;
}

	
	
	
	
	public void draw(Graphics g){
		for(int i=0;i<lifeCount;i++){
			g.drawImage(Images.imgs.get("plane_small"),40+60*i,Constant.GAME_HEIGHT-80,null);
		}
		if(!live){
			return;
		}
		g.drawImage(img,x,y,null);
		if(good){
			//��Ѫ��
			bb.draw(g);
			move();
		}else{
			
			this.speed =1;
			enemyMove();
		}
		
	} 
	
	public void enemyMove(){
		this.preX = x;
		this.preY = y;
		switch(dir){
		case LEFT:
			x -= speed;
			break;
		case LEFT_UP:
			x -= speed;
			y -= speed;
			break;
		case UP:
			y -= speed;
			break;
		case RIGHT_UP:
			x += speed;
			y -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		case RIGHT_DOWN:
			x += speed;
			y += speed;
			break;
		case DOWN:
			y += speed;
			break;
		case LEFT_DOWN:
			x -= speed;
			y += speed;
			break;
		default:
			break;
		}
		//outOfBound();
		//��������ӵ�
		if(r.nextInt(101)>98) fire();
	}
	/**public void enemyMove1(){
		y = (int)(Math.sin(x));
		x = x + speed;
		if(r.nextInt(101)>98) fire();
	}
	**/
	
	/**
	 * ��Ӽ��̿����¼�,����ʱ����Ϊtrue
	 * @param e
	 */
	public void keyPressed(KeyEvent e){
		switch (e.getKeyCode()){
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_J:
			//���ӵ�����
			if(this.live){ fire();
			File f1 = new File("music/bullet.wav");
            try {
             url= f1.toURL();
            } catch (MalformedURLException e1) {      
              e1.printStackTrace();
            } 
            ac= Applet.newAudioClip(url);
            ac.play();

			}
			break;
		case KeyEvent.VK_K:
			//�ɻ�����
			rebirth();
			break;
		default:
			break;
		}
		confirmDirection();
	}
	
	/**
	 * ���Ƿɻ��ƶ��ķ���
	 */
	public void move(){
		this.preX = x;
		this.preY = y;
		if(left) 
			x -= speed;
		if(up) 
			y -= speed;
		if(right) 
			x += speed;
		if(down) 
			y += speed;
		
		outOfBound();
	}
		/**
		 * ���Ƿɻ����߽�ķ���
		 */
	private void outOfBound(){
		if(x<0){
			x = 0;
		}
		if(x>Constant.GAME_WIDHT - img.getWidth(null)){
			x = Constant.GAME_WIDHT - img.getWidth(null);
		}
		if(y<30){
			y = 30;
		}
		if(y>Constant.GAME_HEIGHT - img.getHeight(null)){
			y = Constant.GAME_HEIGHT - img.getHeight(null);
		}
	}
		
	
	
	/**
	 * ��Ӽ��̿����¼�,�ɿ�ʱ����Ϊfasle
	 * @param e
	 */
	public void keyReleased(KeyEvent e){
		switch (e.getKeyCode()){
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
			default:
				break;
			
		
			}
		confirmDirection();
		}
	/**
	 *���嵱ǰ�ɻ�����ķ���
	 *
	 */
	public void confirmDirection(){
		//left
		
		if(left && !up && !right && !down){
			dir = Direction.LEFT;
		}else if(left && up && !right && !down){
			dir = Direction.LEFT_UP;
		}else if(!left && up && !right && !down){
			dir = Direction.UP;
		}else if(!left && up && right && !down){
			dir = Direction.RIGHT_UP;
		}else if(!left && !up && right && !down){
			dir = Direction.RIGHT;
		}else if(!left && !up && right && down){
			dir = Direction.RIGHT_DOWN;
		}else if(!left && !up && !right && down){
			dir = Direction.DOWN;
		}else if(left && !up && !right && down){
			dir = Direction.LEFT_DOWN;
		}else{
			dir = Direction.STOP;
		}
	}
	
	
	/**
	 * �ɻ����������ӵ��ķ���
	 */
	public void fire(){
		//Bullet b1 = new Bullet(x+this.img.getWidth(null)/2-45,y,Direction.UP,pws,good);
		
		//Bullet b2 = new Bullet(x+this.img.getWidth(null)/2-19,y,Direction.RIGHT_DOWN,pws,good);
		if(good){
			
			Bullet b3 = new Bullet(x+this.img.getWidth(null)/2-8,y,Direction.UP,pws,good);
			pws.bullets.add(b3);
			if(c){
				Bullet b1 = new Bullet(x+this.img.getWidth(null)/2-50,y,Direction.UP,pws,good);
				Bullet b5 = new Bullet(x+this.img.getWidth(null)/2+28,y,Direction.UP,pws,good);
				pws.bullets.add(b1);
				pws.bullets.add(b5);
				
			}
		}else{
		
			Bullet b3 = new Bullet(x+this.img.getWidth(null)/2-8,y,Direction.DOWN,pws,good,Images.imgs.get("bulletmiddle"));
			b3.speed = 15;
			pws.bullets.add(b3);
		}
		//Bullet b4 = new Bullet(x+this.img.getWidth(null)/2+10,y,Direction.LEFT_DOWN,pws,good);
		//Bullet b5 = new Bullet(x+this.img.getWidth(null)/2+28,y,Direction.UP,pws,good);
		
		
		
		//ÿnew һ���ӵ��������������һ��
		//pws.bullets.add(b1);
		//pws.bullets.add(b2);
		//pws.bullets.add(b3);
		//pws.bullets.add(b4);
		//pws.bullets.add(b5);
		
	}
	public Rectangle getRect(){
		return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
	}
	
	public boolean concatWithObstruction(Obstruction ob){
		if(this.getRect().intersects(ob.getRect())){
			//this.dir = Direction.STOP;
			this.rollBacktoPrePosition();
			//�ϰ��Ｗѹ�ɻ������˶�
			this.y += ob.speed;
			//׹��
			if(this.y>Constant.GAME_HEIGHT-img.getHeight(null) ){
				if(this.isLive()&&good){
					this.setLive(false);//�ɻ�����
					//���ɱ�ը
					Explode e = new Explode(this.x,this.y,pws);
					pws.explodes.add(e);
					if(this.getLifeCount()>0){
						this.setLifeCount(this.getLifeCount()-1);
						}
					}
		
				}
			
			return true;
		}else{
			return false;
		}
	}
	public boolean concatWithObstructions(List<Obstruction> obs){
		for(int i=0;i<obs.size();i++){
			Obstruction ob = obs.get(i);
			if(this.concatWithObstruction(ob)){
				return true;
			}
		}
		return false;
		
	}
	private void rollBacktoPrePosition(){
		this.x = this.preX;
		this.y = this.preY;
	}
	
	public BloodBar bb = new BloodBar();
	
	class BloodBar{
		public void draw(Graphics g){
		Color c = g.getColor();
		//g.setColor(Color.RED);
		
		if(img.getWidth(null)*life/100>=70){
			g.setColor(Color.GREEN);
			g.drawRect(x,y-10,img.getWidth(null),5);
			g.fillRect(x,y-10, img.getWidth(null)*life/100, 5);
		}else{
			if(img.getWidth(null)*life/100>=40){
			g.setColor(Color.ORANGE);
			g.drawRect(x,y-10,img.getWidth(null),5);
			g.fillRect(x,y-10, img.getWidth(null)*life/100, 5);
			}else{
				g.setColor(Color.RED);
				g.drawRect(x,y-10,img.getWidth(null),5);
				g.fillRect(x,y-10, img.getWidth(null)*life/100, 5);
				}
			}
		
		g.setColor(c);
		}
	}
	
	public void rebirth(){
		if(!live && lifeCount>0){
			this.setLive(true);
			this.setLife(100);
			this.x = 400;
			this.y = 600;
			
		}
	}
	
	/**
	 * �ɻ��Ե��߼ӹ���
	 */
	public boolean eatItem(Item item){
		if(item.isLive()&&good&& live && lifeCount>0 && this.getRect().intersects(item.getRect())){
			if(item.getCategory()==0){
				if(life<100){
					this.setLife(this.getLife()+20);
				}
				if(life>=100){
					this.setLife(100);
					}
			}
			if(item.getCategory()==1){
				for(int i=0;i<6;i++){
				Bullet bu= new Bullet(0,0,Direction.DOWN,pws,true,Images.imgs.get("jg"));
				bu.speed = 15;
				pws.bullets.add(bu);
				}
			}
			if(item.getCategory()==2){
				if(this.getLifeCount()<6){
				this.setLifeCount(this.getLifeCount()+1);
				}
			}
			if(item.getCategory()==3){
				
				c=true;
				this.img=Images.imgs.get("plane21");
			}
			
			
				item.setLive(false);
				return true;
				
				}else{			
					 return false;
				}
		
	}
	public boolean eatItems(List<Item> items){
		for(int i=0;i<items.size();i++){
			Item item = items.get(i);
			if(eatItem(item)){
				return true;
			}
		}
		return false;
	}
	
	
}
