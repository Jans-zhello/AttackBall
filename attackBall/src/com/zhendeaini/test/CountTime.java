package com.zhendeaini.test;


//��JAVA��дʱ����棬ʱ�ӽ������Ҫ���п̶ȣ�ʱ���������룬�������ɨ������Բ	 	
 		 

import java.util.*; 
import java.awt.*; 
import java.applet.*; 
//Implements Runnable ���̳߳���Ľӿ� 
public class CountTime extends Applet implements Runnable 
{ 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Thread timer=null; //�����߳�ʵ��timer 
int xcenter=400,ycenter=50; 
int Radius=ycenter-5; 
public void init() 
{ 
resize(400,125);//����ʱ�ӳ���Ĵ��ڴ�С 
setBackground(Color.white);//����СӦ�ó���ı���ɫ 
} 
@SuppressWarnings("deprecation")
public void paint(Graphics g) 
{ 
int xh,yh,xm,ym,xs,ys,s,m,h; 
String today; 
Date dat=new Date(); //����ʱ����dat 
s=dat.getSeconds(); //���ʱ���� 
m=dat.getMinutes(); //���ʱ��� 
h=dat.getHours(); 
today=dat.toLocaleString(); //����ַ���ʱ���ʽ 
g.clearRect(0,0,size().width,size().height); //����СӦ�ó��� 
xcenter=xcenter-1; //�����ƶ�һ�����ص� 
if(xcenter<-50) 
xcenter=400; //���centerС��-50����ص���ʼλ�� 
//����������� 
xs=(int)(Math.cos(s*3.14f/30-3.14f/2)*(Radius-5)+xcenter); 
ys=(int)(Math.sin(s*3.14f/30-3.14f/2)*(Radius-5)+ycenter); //������ӵ����� 
xm=(int)(Math.cos(m*3.14f/30-3.14f/2)*(Radius-10)+xcenter); 
ym=(int)(Math.sin(m*3.14f/30-3.14f/2)*(Radius-10)+ycenter); //����Сʱ������ 
xh=(int)(Math.cos((h*30+m/2)*3.14f/180-3.14f/2)*(Radius-20)+xcenter); 
yh=(int)(Math.sin((h*30+m/2)*3.14f/180-3.14f/2)*(Radius-20)+ycenter); 
g.setColor(Color.darkGray); //������ɫ 
g.drawString("9",xcenter-(Radius-5),ycenter+3); //��ʾʱ���ϵ����֡�9�� 
g.drawString("3",xcenter+(Radius-10),ycenter+3); //��ʾʱ���ϵ����֡�3�� 
g.drawString("12",xcenter-5,ycenter-(Radius-13)); //��ʾʱ���ϵ�����'12' 
g.drawString("6",xcenter-3,ycenter+(Radius-10)); //��ʾʱ���ϵ�����'6' 
g.drawString(today,0,125); //��ʾ�ַ���ʱ�� 
g.drawLine(xcenter,ycenter,xs,ys); //������ 
g.setColor(Color.blue); //������ɫ 
g.drawArc(xcenter-Radius,ycenter-Radius,2*Radius,2*Radius,0,360); //���� 
g.drawLine(xcenter,ycenter-1,xm,ym); //������ 
g.drawLine(xcenter-1,ycenter,xm,ym); //������ 
g.drawLine(xcenter,ycenter-1,xh,yh); //��ʱ�� 
g.drawLine(xcenter-1,ycenter,xh,yh); //��ʱ�� 
} 
public void start() 
{ 
if(timer==null) 
{ 
timer=new Thread(this); //����Thread(���̳߳���)�Ķ���ʵ�� 
timer.start(); //�������ɵ��߳� 
} 
} 
@SuppressWarnings("deprecation")
public void stop() 
{ 
timer.stop(); //ֹͣ�̵߳Ĺ��� 
timer=null; //�ŵ�Thread���� 
} 
public void run() //�ķ������������߳��壬һ���̱߳�����ִ�У��Ϳ�ʼִ��������� 
{ 
while(timer!=null) 
{ 
try 
{ 
Thread.sleep(150); //ʹ��ǰ����ִ�е��߳̽���˯��ʱ���ɲ���millisȷ���� 
//��λʱ���Ǻ��룬�����ʱ���ȥ���̼߳������е� 
while(timer!=null) 
{ 
try 
{ 
Thread.sleep(150);//ʹ�õ�ǰ����ִ�е��߳̽���˯��ʱ���ɲ��� 
//millisȷ��,��λ�Ǻ��룬�����ʱ���ȥ���̼߳�Ϊ�����е� 
} 
catch(InterruptedException e) 
{} 
repaint(); //repaint����������ʵ��ȥ���÷���uadate�ػ�ЧӦ�ó��� 
} 
timer=null; 
} 
catch(InterruptedException e) 
{} 
} 
} 
//�����Ĺ������Ƚ�����ЧӦ�ó��������������ȥ����paint������ػ��Ķ��� 
public void update(Graphics g) 
{ 
paint(g); 
} 
}