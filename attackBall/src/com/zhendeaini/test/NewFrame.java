package com.zhendeaini.test;

import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class NewFrame extends JFrame {
 
    private JLabel jl;
    public NewFrame(){
        jl = new JLabel();
        add(jl);
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Thread t = new Thread(new Runnable(){
            @Override
           public void run(){
            	System.out.println("还在执行");
            	jl.setText("呈现文字.5秒后消失");
                try {
                    Thread.sleep(5000);//该线程睡眠5秒
                } catch (InterruptedException ex) {
                }
                jl.setText(null);//清空文字
            }
        });
        t.start();//启动线程
        
    }
 
    public static void main(String[] args) {
        new NewFrame();
    }
}