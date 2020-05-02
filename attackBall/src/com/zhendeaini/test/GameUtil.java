package com.zhendeaini.test;
//游戏项目中常用的工具类(比如加载图片等方法)
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {

	/**
	 * @param args
	 */
  private GameUtil(){}//工具类构造方法通常私有直接调用它的static方法
  public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage image = null;
		try {
			image = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
		
	}

}
