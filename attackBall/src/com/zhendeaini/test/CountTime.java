package com.zhendeaini.test;


//用JAVA编写时间界面，时钟界面必须要带有刻度，时分秒三根针，秒针可以扫过整个圆	 	
 		 

import java.util.*; 
import java.awt.*; 
import java.applet.*; 
//Implements Runnable 是线程程序的接口 
public class CountTime extends Applet implements Runnable 
{ 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Thread timer=null; //定义线程实体timer 
int xcenter=400,ycenter=50; 
int Radius=ycenter-5; 
public void init() 
{ 
resize(400,125);//设置时钟程序的窗口大小 
setBackground(Color.white);//设置小应用程序的背景色 
} 
@SuppressWarnings("deprecation")
public void paint(Graphics g) 
{ 
int xh,yh,xm,ym,xs,ys,s,m,h; 
String today; 
Date dat=new Date(); //定义时间类dat 
s=dat.getSeconds(); //获得时间秒 
m=dat.getMinutes(); //获得时间分 
h=dat.getHours(); 
today=dat.toLocaleString(); //获得字符串时间格式 
g.clearRect(0,0,size().width,size().height); //消除小应用程序 
xcenter=xcenter-1; //向左移动一个像素点 
if(xcenter<-50) 
xcenter=400; //如果center小于-50，则回到初始位置 
//计算秒的坐标 
xs=(int)(Math.cos(s*3.14f/30-3.14f/2)*(Radius-5)+xcenter); 
ys=(int)(Math.sin(s*3.14f/30-3.14f/2)*(Radius-5)+ycenter); //计算分钟的坐标 
xm=(int)(Math.cos(m*3.14f/30-3.14f/2)*(Radius-10)+xcenter); 
ym=(int)(Math.sin(m*3.14f/30-3.14f/2)*(Radius-10)+ycenter); //计算小时的坐标 
xh=(int)(Math.cos((h*30+m/2)*3.14f/180-3.14f/2)*(Radius-20)+xcenter); 
yh=(int)(Math.sin((h*30+m/2)*3.14f/180-3.14f/2)*(Radius-20)+ycenter); 
g.setColor(Color.darkGray); //设置颜色 
g.drawString("9",xcenter-(Radius-5),ycenter+3); //显示时钟上的数字‘9’ 
g.drawString("3",xcenter+(Radius-10),ycenter+3); //显示时钟上的数字‘3’ 
g.drawString("12",xcenter-5,ycenter-(Radius-13)); //显示时钟上的数字'12' 
g.drawString("6",xcenter-3,ycenter+(Radius-10)); //显示时钟上的数字'6' 
g.drawString(today,0,125); //显示字符串时钟 
g.drawLine(xcenter,ycenter,xs,ys); //画秒针 
g.setColor(Color.blue); //设置颜色 
g.drawArc(xcenter-Radius,ycenter-Radius,2*Radius,2*Radius,0,360); //画钟 
g.drawLine(xcenter,ycenter-1,xm,ym); //画分针 
g.drawLine(xcenter-1,ycenter,xm,ym); //画分针 
g.drawLine(xcenter,ycenter-1,xh,yh); //画时针 
g.drawLine(xcenter-1,ycenter,xh,yh); //画时针 
} 
public void start() 
{ 
if(timer==null) 
{ 
timer=new Thread(this); //生成Thread(多线程程序)的对象实体 
timer.start(); //启动生成的线程 
} 
} 
@SuppressWarnings("deprecation")
public void stop() 
{ 
timer.stop(); //停止线程的工作 
timer=null; //放掉Thread对象 
} 
public void run() //改方法用来定义线程体，一旦线程被启动执行，就开始执行这个方法 
{ 
while(timer!=null) 
{ 
try 
{ 
Thread.sleep(150); //使当前正在执行的线程进入睡眠时间由参数millis确定， 
//单位时间是毫秒，当这个时间过去，线程即可运行的 
while(timer!=null) 
{ 
try 
{ 
Thread.sleep(150);//使用当前正在执行的线程进入睡眠时间由参数 
//millis确定,单位是毫秒，当这个时间过去，线程即为可运行的 
} 
catch(InterruptedException e) 
{} 
repaint(); //repaint所做的事其实是去调用方法uadate重画效应用程序 
} 
timer=null; 
} 
catch(InterruptedException e) 
{} 
} 
} 
//所做的工作是先将整个效应用程序区域清除，再去调用paint，完成重画的动作 
public void update(Graphics g) 
{ 
paint(g); 
} 
}