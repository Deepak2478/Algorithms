package com.swing.test;

import javax.swing.*;

//import com.teamdev.jxbrowser.Browser;

import java.awt.Dimension;
//import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.event.*;
import java.io.IOException;
 
 
class Console implements ActionListener
{
    JFrame f;
    JTextField t;
    JTextArea ta;
    JButton b1,b2,b3,b4,beq,bdel,bclr;
    static double a=0,b=0;
    String result;
    static int operator=0;
 
    Console()
    {
        f=new JFrame("Truck Console");
        t=new JTextField();
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        beq=new JButton("Send");
        bdel=new JButton("Delete");
        bclr=new JButton("Clear");
        ta = new JTextArea("Instructions:",3,3);
        
        t.setBounds(30,40,280,30);
        b1.setBounds(30,100,280,30);
        b2.setBounds(30,160,280,30);
        b3.setBounds(30,220,280,30);
        b4.setBounds(30,280,280,30);        
        beq.setBounds(30,340,280,30);
        bdel.setBounds(60,380,100,40);
        bclr.setBounds(180,380,100,40);        
        ta.setBounds(30,440,280,30);
        
        f.add(t);
        f.add(b4);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(beq);
        f.add(bdel);
        f.add(bclr);
        f.add(ta);
        
       // f.setLayout(null);
       // f.setVisible(true);
        //f.setSize(400,600);
      //  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // f.setResizable(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        beq.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
        
        JEditorPane jep = new JEditorPane();
		jep.setEditable(false);

		try {
			//jep.setPage("http://10.52.237.239:8080/SmartTruck/");
			jep.setPage("http://www.google.com");
			System.out.println("welcome");
		} catch (IOException e) {
			e.printStackTrace();
			jep.setContentType("text/html");
			jep.setText("<html>Could not load</html>");
		}

		JScrollPane scrollPane = new JScrollPane(jep); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(scrollPane);
		f.setPreferredSize(new Dimension(100, 100));
		f.setVisible(true); 
    }
 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            t.setText("Request Type-1");
        	operator=1;
        }
        if(e.getSource()==b2)
        {
            t.setText("Request Type-2");
        	operator=2;
        }
        if(e.getSource()==b3)
        {
        	t.setText("Request Type 3");
        	operator=3;
        }
        if(e.getSource()==b4)
        {
        	t.setText("Request Type 4");
        	operator=4;
        }
        if(e.getSource()==beq)
        {
        
            switch(operator)
            {
                case 1: result="1st request is sent";
                    break;
        
                case 2: result="2nd request is sent";
                    break;
        
                case 3: result="3rd request is sent";
                    break;
        
                case 4: result="4th request is sent";
                    break;
        
                default: result="No request";
            }
        
            ta.setText(result);
        }
        
        if(e.getSource()==bclr)
            t.setText("");
        	//ta.setText("");
        
        if(e.getSource()==bdel)
        {
            String s=t.getText();
            t.setText("");
            for(int i=0;i<s.length()-1;i++)
            t.setText(t.getText()+s.charAt(i));
        }        
    }
 
    public static void main(String...s)
    {
        new Console();
    }
}