package com.zhendeaini.test;
//窗口的主要操作
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
    public void launchFrame(){//加载窗口，其中宽度和高度的问题以及位置(算矩形的左上角为基准)的问题
	  	   setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//设置窗口高度和宽度
	  	   setLocation(100, 100);//设置位置左上角点的坐标
	       setVisible(true);//设置窗口可见  因为窗口默认不可见
	        new PaintThread().start();//启动我们的重画线程
	        /**
	         * 增加监听器使用匿名内部类实现窗口关闭功能
	         */
	       addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e) {
				     System.exit(0);
		        }
	      });
	  }
    private Image offScreenImage = null;
    public void update (Graphics g){
 	   if (offScreenImage == null){
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
    }
 	   Graphics goff = offScreenImage.getGraphics();
 	   paint(goff);
 	   g.drawImage(offScreenImage, 0, 0, null);
    }
	class PaintThread extends Thread{//利用线程定义一个重画窗口的线程类且是一个内部类
		   public void run(){//重写父类方法
			   while(true){//死循环
				   repaint();//实现重画窗口，该类为内部类，这个方法本为外部类的方法,可以直接用
				   try {
					Thread.sleep(10);//1s=1000毫秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			   }
			   
		  }
	 }
	
}
