package com.zhendeaini.test;
//实现椭圆轨迹飞行
import java.awt.Graphics;
import java.awt.Image;

public class GameFrame04 extends MyFrame {

   Image img = GameUtil.getImage("images/2345_image_file_copy_2.jpg") ;
   private double x=120,y=120;
   private double degree=3.14/7;//弧度属于【0,2pi】实现可某一沿角度飞
  
   public void paint(Graphics g) {//在窗口中实现画东西,系统自动掉不用自己掉，且g就相当于一只画笔
		   g.drawImage(img,(int)x,(int)y,null);//通过添加变量实现动画中动的实现
              
		   //x+=3;
		   //y+=3;
		   x += 10*Math.cos(degree);
		   y += 15*Math.sin(degree);
		   degree += 0.1;//角度的任意切换实现椭圆轨迹飞行
			
			
				
	}
	  public static void main(String[] args){
	  	   GameFrame04 gf = new GameFrame04();
	  	   gf.launchFrame();
	  }
	}
