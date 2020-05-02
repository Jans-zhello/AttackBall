package com.zhendeaini.test;
//��Ϸ��Ŀ�г��õĹ�����(�������ͼƬ�ȷ���)
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {

	/**
	 * @param args
	 */
  private GameUtil(){}//�����๹�췽��ͨ��˽��ֱ�ӵ�������static����
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
