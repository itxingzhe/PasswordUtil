package com.pilgrim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Save extends JFrame implements ActionListener {
    JFrame f  = new JFrame("±£¥Ê√‹¬Î");

    JLabel jl1 = new JLabel("Õ¯’æ√˚≥∆:");
    JLabel jl2 = new JLabel("’À        ∫≈:");
    JLabel jl3 = new JLabel("√‹        ¬Î:");
    JTextField jt1 = new JTextField(16);
    JTextField jt2 = new JTextField(16);
    JTextField jt3= new JTextField(16);
    JButton jb1 = new JButton("»∑∂®");
    JButton jb2 = new JButton("÷ÿ÷√");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();

    public void init(String pwd){

        if(pwd!=null){
            jt3.setText(pwd);
        }
        if(pwd==null){
            jt3.setText("");
        }

        f.setSize(300,200);
        f.setLayout(new GridLayout(4,2));
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        jp1.add(jl1);
        jp1.add(jt1);
        jp2.add(jl2);
        jp2.add(jt2);
        jp3.add(jl3);
        jp3.add(jt3);
        jp4.add(jb1);
        jp4.add(jb2);


        f.add(jp1);
        f.add(jp2);
        f.add(jp3);
        f.add(jp4);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("»∑∂®")){
            String webname = jt1.getText();
            String username = jt2.getText();
            String password = jt3.getText();
            if((webname.equals("")&&username.equals(""))||(webname.equals("")||username.equals(""))){
                JOptionPane.showMessageDialog(f,"«Î ‰»ÎÕ¯’æ√˚≥∆∫Õ’À∫≈£°");
            }else {
                if(File(webname,username,password)){
                    JOptionPane.showMessageDialog(f,"±£¥Ê≥…π¶£°");
                    f.dispose();
                }else {
                    JOptionPane.showMessageDialog(f,"±£¥Ê ß∞‹£°");
                    f.dispose();
                }
            }
        }
        if(cmd.equals("÷ÿ÷√")){
            jt1.setText("");
            jt2.setText("");
        }
    }

    public boolean File(String webname,String username,String password){
        boolean flag = false;
        OutputStreamWriter out = null;
        if(flag!=true){
            try{
                out = new OutputStreamWriter(new FileOutputStream("Password.txt",true),"utf-8");
                out.append("Õ¯’æ√˚≥∆£∫"+webname);
                out.append("\r\n");
                out.append("’À∫≈£∫"+username);
                out.append("\r\n");
                out.append("√‹¬Î£∫"+password);
                out.append("\r\n");
                out.append("\r\n");
                out.flush();
                flag = true;
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}