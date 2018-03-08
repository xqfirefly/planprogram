package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

public class GameUtil {
	
	
	/**
	 * ����ͼƬ�ķ���
	 * @param impath ͼƬ����Ŀ�е�·��
	 * @return image����
	 */
	public static Image getImage(String impath){
		URL u = GameUtil.class.getClassLoader().getResource(impath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
