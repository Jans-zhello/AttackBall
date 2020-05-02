package com.zhendeaini.test;
//模仿
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口基本知识类
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
public class GameFrame extends MyFrame{//GUI编程(AWT,Swing)
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
        * 加载窗口
        */
	Image img = GameUtil.getImage("images/2345_image_file_copy_1.jpg") ;
	private double x,y;
   public void paint(Graphics g) {//在窗口中实现画东西,系统自动掉不用自己掉，且g就相当于一只画笔
		g.drawLine(100,100,200,200);//这个时候的坐标以窗口左上角为基本,画线
		g.drawRect(100,100,200,200);//画一个矩形
		g.drawOval(100, 100, 200, 200);//画一个圆与画矩形实质一样
		Font f = new Font("宋体",Font.BOLD,100);//设置字体
		g.setFont(f);
		//g.setColor(Color.white);//可设置画笔颜色，最好不要乱改
		g.drawString("我是张子震", 400, 400);//添加字符串
		g.fillRect(100, 100, 20, 20);//填充一个这样的矩形
		Color c = g.getColor();//改颜色之前最好先保存一下
		g.fillOval(100, 200, 20, 20);//填充一个这样的圆
		g.setColor(c);//用完之后在改回来
		x+=3;
		y+=3;
		g.drawImage(img,(int)x,(int)y,null);//通过添加变量实现动画的实现
//		int a = img.getHeight(null);//检验该方法
//		System.out.println(a);
//		g.drawImage(img, 0, 0, null);
//		System.out.println("&&&");
		
	}

   public static void main(String[] args){
    	   GameFrame gf = new GameFrame();
    	   gf.launchFrame();
    }
}
