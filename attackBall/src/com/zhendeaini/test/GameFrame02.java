package com.zhendeaini.test;
import java.awt.Graphics;
import java.awt.Image;
public class GameFrame02 extends MyFrame{

	/**���Դ����������Ÿ��ֹ켣�ƶ����ӻ���
	 * @param args
	 */
    
	Image img = GameUtil.getImage("images/2345_image_file_copy_1.jpg") ;
	
	private double x=100,y=100;
	private boolean left;
	private boolean  up;
    public void paint(Graphics g) {//�ڴ�����ʵ�ֻ�����,ϵͳ�Զ��������Լ�������g���൱��һֻ����
	   g.drawImage(img,(int)x,(int)y,null);//ͨ����ӱ���ʵ�ֶ�����ʵ��
		if(left){
			x-=3;
		}else {
			x+=3;
		}
		if(x>500-230){
			left = true;
		}
		if(x<0){
			left = false;
		}
		if(up){
			y-=3;
		}else {
			y+=3;
		}
		if(y>500-230){
			up = true;
		}
		if(y<30){
			up = false;
		}
	}
 
 
 public static void main(String[] args){
  	   GameFrame02 gf = new GameFrame02();
  	   gf.launchFrame();
  }
	
	
	
	
}
