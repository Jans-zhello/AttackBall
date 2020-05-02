package com.zhendeaini.test;

import java.awt.Graphics;
import java.awt.Image;
public class GameFrame03 extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**测试窗口物体沿着各种轨迹移动以及台球运动的实现
	 * @param args
	 */
	Image img = GameUtil.getImage("images/yellow_ball.png");
	Image bg = GameUtil.getImage("images/table.jpg");
	private double x=100,y=100;
	private double degree=3.14/1.5;//弧度属于【0,2pi】实现可某一沿角度飞
	private double speed=10;
   public void paint(Graphics g) {//在窗口中实现画东西,系统自动掉不用自己掉，且g就相当于一只画笔
	  System.out.println(speed);
	   g.drawImage(bg, 1, 17, null);
	   g.drawImage(img,(int)x,(int)y,null);//通过添加变量实现动画中动的实现
	   if(speed>0){
		   System.out.println("我被执行了");
    	   speed -= 0.1; //实现运动的停止
    	   System.out.println(speed);
       }else {
    	   speed = 0;
	   }
	   // degree+=0.1;
	    x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>550-20||y<20){
			degree = -degree;//实现改变方向。此类属于x方向不变，y方向相反即可
		}
		if(x>800-25||x<25){
			degree = Math.PI - degree;//实现改变方向。此类属于y方向不变，x方向相反即可
		}
		
			
}
  public static void main(String[] args){
  	   GameFrame03 gf = new GameFrame03();
  	   gf.launchFrame();
  }
}

