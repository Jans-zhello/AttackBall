package com.zhendeaini.test;
//���ڵ���Ҫ����
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
    public void launchFrame(){//���ش��ڣ����п�Ⱥ͸߶ȵ������Լ�λ��(����ε����Ͻ�Ϊ��׼)������
	  	   setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//���ô��ڸ߶ȺͿ��
	  	   setLocation(100, 100);//����λ�����Ͻǵ������
	       setVisible(true);//���ô��ڿɼ�  ��Ϊ����Ĭ�ϲ��ɼ�
	        new PaintThread().start();//�������ǵ��ػ��߳�
	        /**
	         * ���Ӽ�����ʹ�������ڲ���ʵ�ִ��ڹرչ���
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
	class PaintThread extends Thread{//�����̶߳���һ���ػ����ڵ��߳�������һ���ڲ���
		   public void run(){//��д���෽��
			   while(true){//��ѭ��
				   repaint();//ʵ���ػ����ڣ�����Ϊ�ڲ��࣬���������Ϊ�ⲿ��ķ���,����ֱ����
				   try {
					Thread.sleep(10);//1s=1000����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			   }
			   
		  }
	 }
	
}
