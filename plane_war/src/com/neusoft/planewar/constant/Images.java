package com.neusoft.planewar.constant;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.neusoft.planewar.util.GameUtil;

public class Images {
	public static String[] imgsPath={
			"com/neusoft/planewar/img/plane2.png",
			"com/neusoft/planewar/img/bullet.png",
			"com/neusoft/planewar/img/bulletg.png",
			"com/neusoft/planewar/img/planezz.png",
			"com/neusoft/planewar/img/planedj.png",
			"com/neusoft/planewar/img/e1.png",
			"com/neusoft/planewar/img/e2.png",
			"com/neusoft/planewar/img/e3.png",
			"com/neusoft/planewar/img/e4.png",
			"com/neusoft/planewar/img/e5.png",
			
			"com/neusoft/planewar/img/bj.jpg",
			
			"com/neusoft/planewar/img/Ì«Ñô1.png",
			
			//¾¯¸æ
			"com/neusoft/planewar/img/w1.png",
			"com/neusoft/planewar/img/w2.png",
			"com/neusoft/planewar/img/w3.png",
			"com/neusoft/planewar/img/w4.png",
			"com/neusoft/planewar/img/w5.png",
			"com/neusoft/planewar/img/w6.png",
			"com/neusoft/planewar/img/w7.png",
			"com/neusoft/planewar/img/w8.png",
			"com/neusoft/planewar/img/w9.png",
			"com/neusoft/planewar/img/w10.png",
			//boss
			"com/neusoft/planewar/img/boss1.png",
			"com/neusoft/planewar/img/boss2.png",
			"com/neusoft/planewar/img/boss3.png",
			"com/neusoft/planewar/img/boss4.png",
			"com/neusoft/planewar/img/boss5.png",
			"com/neusoft/planewar/img/boss6.png",
			"com/neusoft/planewar/img/boss7.png",
			"com/neusoft/planewar/img/boss8.png",
			"com/neusoft/planewar/img/boss9.png",
			
			"com/neusoft/planewar/img/bossbullet.png",
			"com/neusoft/planewar/img/enbullet.png",
			
			"com/neusoft/planewar/img/boss_small.png",
			
			"com/neusoft/planewar/img/plane_small.png",
			
			"com/neusoft/planewar/img/blood.png",
			//GameOverÍ¼
			"com/neusoft/planewar/img/game/g1.png",
			"com/neusoft/planewar/img/game/g2.png",
			"com/neusoft/planewar/img/game/g3.png",
			"com/neusoft/planewar/img/game/g4.png",
			"com/neusoft/planewar/img/game/g5.png",
			"com/neusoft/planewar/img/game/g6.png",
			"com/neusoft/planewar/img/game/g7.png",
			"com/neusoft/planewar/img/game/g8.png",
			"com/neusoft/planewar/img/game/g9.png",
			//startÍ¼
			"com/neusoft/planewar/img/start/start.png",
			//
			"com/neusoft/planewar/img/growthspeed.png",
			"com/neusoft/planewar/img/jg.png",
			"com/neusoft/planewar/img/plane21.png",
			"com/neusoft/planewar/img/planechange.png",
			
			"com/neusoft/planewar/img/planedj2.png",
			"com/neusoft/planewar/img/planedj3.png",
			
			"com/neusoft/planewar/img/bg1.png",		
	};
	public static Map<String,Image> imgs = new HashMap<>();
	static {
		imgs.put("myPlane",GameUtil.getImage(imgsPath[0]));
		imgs.put("bulletdown",GameUtil.getImage(imgsPath[1]));
		imgs.put("bulletborder",GameUtil.getImage(imgsPath[2]));
		imgs.put("bulletmiddle",GameUtil.getImage(imgsPath[3]));
		imgs.put("enemyPlane",GameUtil.getImage(imgsPath[4]));
		
		imgs.put("e1",GameUtil.getImage(imgsPath[5]));
		imgs.put("e2",GameUtil.getImage(imgsPath[6]));
		imgs.put("e3",GameUtil.getImage(imgsPath[7]));
		imgs.put("e4",GameUtil.getImage(imgsPath[8]));
		imgs.put("e5",GameUtil.getImage(imgsPath[9]));

		imgs.put("bg",GameUtil.getImage(imgsPath[10]));
		
		imgs.put("muxing",GameUtil.getImage(imgsPath[11]));
		//
		imgs.put("w1",GameUtil.getImage(imgsPath[12]));
		imgs.put("w2",GameUtil.getImage(imgsPath[13]));
		imgs.put("w3",GameUtil.getImage(imgsPath[14]));
		imgs.put("w4",GameUtil.getImage(imgsPath[15]));
		imgs.put("w5",GameUtil.getImage(imgsPath[16]));
		imgs.put("w6",GameUtil.getImage(imgsPath[17]));
		imgs.put("w7",GameUtil.getImage(imgsPath[18]));
		imgs.put("w8",GameUtil.getImage(imgsPath[19]));
		imgs.put("w9",GameUtil.getImage(imgsPath[20]));
		imgs.put("w10",GameUtil.getImage(imgsPath[21]));

		imgs.put("boss1",GameUtil.getImage(imgsPath[22]));
		imgs.put("boss2",GameUtil.getImage(imgsPath[23]));
		imgs.put("boss3",GameUtil.getImage(imgsPath[24]));
		imgs.put("boss4",GameUtil.getImage(imgsPath[25]));
		imgs.put("boss5",GameUtil.getImage(imgsPath[26]));
		imgs.put("boss6",GameUtil.getImage(imgsPath[27]));
		imgs.put("boss7",GameUtil.getImage(imgsPath[28]));
		imgs.put("boss8",GameUtil.getImage(imgsPath[29]));
		imgs.put("boss9",GameUtil.getImage(imgsPath[30]));

		imgs.put("bossbullet",GameUtil.getImage(imgsPath[31]));
		imgs.put("enbullet",GameUtil.getImage(imgsPath[32]));

		imgs.put("boss_small",GameUtil.getImage(imgsPath[33]));
		
		imgs.put("plane_small",GameUtil.getImage(imgsPath[34]));
		
		imgs.put("blood",GameUtil.getImage(imgsPath[35]));
		//gameover
		imgs.put("g1",GameUtil.getImage(imgsPath[36]));
		imgs.put("g2",GameUtil.getImage(imgsPath[37]));
		imgs.put("g3",GameUtil.getImage(imgsPath[38]));
		imgs.put("g4",GameUtil.getImage(imgsPath[39]));
		imgs.put("g5",GameUtil.getImage(imgsPath[40]));
		imgs.put("g6",GameUtil.getImage(imgsPath[41]));
		imgs.put("g7",GameUtil.getImage(imgsPath[42]));
		imgs.put("g8",GameUtil.getImage(imgsPath[43]));
		imgs.put("g9",GameUtil.getImage(imgsPath[44]));

		//start
		imgs.put("start",GameUtil.getImage(imgsPath[45]));
		
		imgs.put("allexplode",GameUtil.getImage(imgsPath[46]));
		
		imgs.put("jg",GameUtil.getImage(imgsPath[47]));
		imgs.put("plane21",GameUtil.getImage(imgsPath[48]));
		imgs.put("planechange",GameUtil.getImage(imgsPath[49]));

		imgs.put("planedj2",GameUtil.getImage(imgsPath[50]));
		imgs.put("planedj3",GameUtil.getImage(imgsPath[51]));
		
		imgs.put("bg1",GameUtil.getImage(imgsPath[52]));
		
	}
}
