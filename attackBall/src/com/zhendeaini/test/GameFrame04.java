package com.zhendeaini.test;
//ʵ����Բ�켣����
import java.awt.Graphics;
import java.awt.Image;

public class GameFrame04 extends MyFrame {

   Image img = GameUtil.getImage("images/2345_image_file_copy_2.jpg") ;
   private double x=120,y=120;
   private double degree=3.14/7;//�������ڡ�0,2pi��ʵ�ֿ�ĳһ�ؽǶȷ�
  
   public void paint(Graphics g) {//�ڴ�����ʵ�ֻ�����,ϵͳ�Զ��������Լ�������g���൱��һֻ����
		   g.drawImage(img,(int)x,(int)y,null);//ͨ����ӱ���ʵ�ֶ����ж���ʵ��
              
		   //x+=3;
		   //y+=3;
		   x += 10*Math.cos(degree);
		   y += 15*Math.sin(degree);
		   degree += 0.1;//�Ƕȵ������л�ʵ����Բ�켣����
			
			
				
	}
	  public static void main(String[] args){
	  	   GameFrame04 gf = new GameFrame04();
	  	   gf.launchFrame();
	  }
	}
