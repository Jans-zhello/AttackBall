package com.zhendeaini.test;

import java.awt.Graphics;
import java.awt.Image;
public class GameFrame03 extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**���Դ����������Ÿ��ֹ켣�ƶ��Լ�̨���˶���ʵ��
	 * @param args
	 */
	Image img = GameUtil.getImage("images/yellow_ball.png");
	Image bg = GameUtil.getImage("images/table.jpg");
	private double x=100,y=100;
	private double degree=3.14/1.5;//�������ڡ�0,2pi��ʵ�ֿ�ĳһ�ؽǶȷ�
	private double speed=10;
   public void paint(Graphics g) {//�ڴ�����ʵ�ֻ�����,ϵͳ�Զ��������Լ�������g���൱��һֻ����
	  System.out.println(speed);
	   g.drawImage(bg, 1, 17, null);
	   g.drawImage(img,(int)x,(int)y,null);//ͨ����ӱ���ʵ�ֶ����ж���ʵ��
	   if(speed>0){
		   System.out.println("�ұ�ִ����");
    	   speed -= 0.1; //ʵ���˶���ֹͣ
    	   System.out.println(speed);
       }else {
    	   speed = 0;
	   }
	   // degree+=0.1;
	    x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>550-20||y<20){
			degree = -degree;//ʵ�ָı䷽�򡣴�������x���򲻱䣬y�����෴����
		}
		if(x>800-25||x<25){
			degree = Math.PI - degree;//ʵ�ָı䷽�򡣴�������y���򲻱䣬x�����෴����
		}
		
			
}
  public static void main(String[] args){
  	   GameFrame03 gf = new GameFrame03();
  	   gf.launchFrame();
  }
}

