package com.zhendeaini.test;
//ģ��
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ���ڻ���֪ʶ��
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
public class GameFrame extends MyFrame{//GUI���(AWT,Swing)
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
        * ���ش���
        */
	Image img = GameUtil.getImage("images/2345_image_file_copy_1.jpg") ;
	private double x,y;
   public void paint(Graphics g) {//�ڴ�����ʵ�ֻ�����,ϵͳ�Զ��������Լ�������g���൱��һֻ����
		g.drawLine(100,100,200,200);//���ʱ��������Դ������Ͻ�Ϊ����,����
		g.drawRect(100,100,200,200);//��һ������
		g.drawOval(100, 100, 200, 200);//��һ��Բ�뻭����ʵ��һ��
		Font f = new Font("����",Font.BOLD,100);//��������
		g.setFont(f);
		//g.setColor(Color.white);//�����û�����ɫ����ò�Ҫ�Ҹ�
		g.drawString("����������", 400, 400);//����ַ���
		g.fillRect(100, 100, 20, 20);//���һ�������ľ���
		Color c = g.getColor();//����ɫ֮ǰ����ȱ���һ��
		g.fillOval(100, 200, 20, 20);//���һ��������Բ
		g.setColor(c);//����֮���ڸĻ���
		x+=3;
		y+=3;
		g.drawImage(img,(int)x,(int)y,null);//ͨ����ӱ���ʵ�ֶ�����ʵ��
//		int a = img.getHeight(null);//����÷���
//		System.out.println(a);
//		g.drawImage(img, 0, 0, null);
//		System.out.println("&&&");
		
	}

   public static void main(String[] args){
    	   GameFrame gf = new GameFrame();
    	   gf.launchFrame();
    }
}
