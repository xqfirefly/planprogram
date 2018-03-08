package com.neusoft.planewar.client;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.BackGround;
import com.neusoft.planewar.core.Boss;
import com.neusoft.planewar.core.Bullet;
import com.neusoft.planewar.core.Explode;
import com.neusoft.planewar.core.GameOver;
import com.neusoft.planewar.core.Item;
import com.neusoft.planewar.core.Obstruction;
import com.neusoft.planewar.core.Plane;
import com.neusoft.planewar.core.Start;
import com.neusoft.planewar.core.Warning;
import com.neusoft.planewar.util.GameUtil;
import com.neusoft.planewar.util.MyFrame;

public  class PlaneWarSystem extends MyFrame  {
	
	public static String jl1;
	public static String jl2;
	public static String jl3;
	static long time =60;
	

	//private static int grade = 0;
	
	private URL url; 
	private  AudioClip ac;

	
	public Start start = new  Start();
	public Plane myplane = new Plane(400,600,true,this,0);
	//public Plane enemyPlane1 = new Plane(700,200,Images.imgsPath[4],false,Direction.LEFT);
	
	
	public BackGround bg = new BackGround();
	
	
	
	//创建很多子弹   <> 泛型
	public List<Bullet> bullets = new ArrayList<>();
	//创建很多敌机
	public static List<Plane> enemyPlanes = new ArrayList<>();
	
	//创建爆炸类的容器
	public List<Explode> explodes = new ArrayList<>();
	
	//创建障碍物
	public Obstruction mx = new Obstruction(this);
	
	//public Obstruction ob = new Obstruction(0,400,500,40,this);
	public List<Obstruction> obs = new ArrayList<>();
	//创建警告
	public Warning warning = new  Warning(this);
	//创建BOSS
	public Boss boss1 = new  Boss(this);
	//创建游戏结束提醒
	public GameOver gameover = new GameOver(this);
	
	//public Item blood = new Item(this);
	public List<Item> bloods = new ArrayList<>();
	
	public void launchFrame(){
		
		File f1 = new File("music/bj.wav");
		
	     try {
	      url= f1.toURL();
	     } catch (MalformedURLException e) {      
	       e.printStackTrace();
	     } 
	     ac= Applet.newAudioClip(url);
	     ac.loop();
	    
	
		super.launchFrame();
		
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				myplane.keyPressed(e);
				
			}
			public void keyReleased(KeyEvent e){
				myplane.keyReleased(e);
			}
		});
		/**
		 * 创建敌人飞机
		 */
		for(int i=0;i<4;i++){
			Plane p = new Plane(50+i*100,-100,false,this,1);
			enemyPlanes.add(p);		
		}
		for(int i=0;i<4;i++){
			Plane p1 = new Plane(850+i*100,-100,false,this,2);	
			enemyPlanes.add(p1);	
		}
		for(int i=0;i<4;i++){
			Plane p2 = new Plane(450+i*100,-100,false,this,3);
			enemyPlanes.add(p2);	
			
		}
		//画障碍物
		obs.add(new Obstruction(0,0,500,40,this));
		obs.add(new Obstruction(0,600,50,400,this));	
	}
	
	public void paint(Graphics g){
		bg.draw(g);
		start.draw(g);
		
		if(start.y>=700){
			Color c=g.getColor();
			g.setColor(Color.RED);
			
		g.drawString("当前游戏剩余时间："+jl1+jl2+jl3, Constant.GAME_WIDHT-300, 80);
		g.drawString("当前积分："+10*(12-enemyPlanes.size()), Constant.GAME_WIDHT-300, 50);
		g.setColor(c);
		for(int i = 0;i<obs.size();i++){
			Obstruction ob =obs.get(i);
			ob.draw(g);
		}
		
		mx.draw(g);
		
		
		if(enemyPlanes.size()<=9){
			warning.draw(g);

			if(myplane.getLifeCount()==0){
				gameover.draw(g);
				
			}else{
				boss1.draw(g);
			}
			
		}
		
		for(int i= 0 ;i<bullets.size();i++){
			Bullet b = bullets.get(i);
			b.draw(g);
			b.hitPlanes(enemyPlanes);
			b.hitPlane(myplane);
			b.hitObstructions(obs);
			b.hitBoss(boss1);
		}
		
		myplane.draw(g);
		myplane.concatWithObstructions(obs);
		
		for(int i= 0;i<enemyPlanes.size();i++){
			Plane p = enemyPlanes.get(i);
			p.draw(g);
			p.concatWithObstructions(obs);
		}
		
		for(int i=0;i<bloods.size();i++){
			Item blood = bloods.get(i);
			blood.draw(g);
			myplane.eatItem(blood);
		}
		
		for(int i= 0;i<explodes.size();i++){
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
	
	}
	}
	public static void  getTime() {
        // 自定义倒计时时间
	 long hour = 0;
     long minute = 0;
     long seconds = 0;

     while (time >= 0) {
         hour = time / 3600;
         minute = (time - hour * 3600) / 60;
         seconds = time - hour * 3600 - minute * 60;
         jl1=( hour+"时");//hour +
         jl2=(minute + "分");
         jl3=(seconds + "秒");
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         time--;
     }
   }
	
	public static void main(String[] args){
		new PlaneWarSystem().launchFrame();
		getTime();
		
	}
	
}
