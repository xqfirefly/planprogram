package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

/**
 * �ɻ���Ŀ��������ɻ��йص�����ĸ���
 * ������
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
