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
            	System.out.println("����ִ��");
            	jl.setText("��������.5�����ʧ");
                try {
                    Thread.sleep(5000);//���߳�˯��5��
                } catch (InterruptedException ex) {
                }
                jl.setText(null);//�������
            }
        });
        t.start();//�����߳�
        
    }
 
    public static void main(String[] args) {
        new NewFrame();
    }
}