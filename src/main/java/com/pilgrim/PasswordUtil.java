package com.pilgrim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PasswordUtil extends JFrame implements ActionListener {
    JFrame jf = new JFrame("����������");
    JLabel jll = new JLabel("���볤��:");
    JTextField tl = new JTextField(10);
    JLabel jl1 = new JLabel("����:");
    JTextField t1 = new JTextField(20);
    JButton jb1 = new JButton("����");
    JButton jb2 = new JButton("����");
    JButton jb3 = new JButton("�������¼");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();

    public void init(){
        jf.setLayout(new GridLayout(3,1));
        jf.setVisible(true);
        jf.setSize(350,200);
        jf.setLocationRelativeTo(this);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp1.add(jll);
        jp1.add(tl);
        jp2.add(jl1);
        jp2.add(t1);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       String text = e.getActionCommand();
       if(text.equals("����")){
           if(t1.getText().equals("δ���ɷ���Ҫ������룬����������")){
               JOptionPane.showMessageDialog(jf,"���������ɷ���Ҫ������룡");
           }else if(t1.getText().equals("")){
               JOptionPane.showMessageDialog(jf,"���벻��Ϊ�գ����������룡");
           } else {
               Save save = new Save();
               save.init(t1.getText());
           }
       }
       if(text.equals("����")){
           String text1 = tl.getText();
           int len = 6;
           try {
               len = Integer.parseInt(text1);
           } catch (Exception ex){
               ex.printStackTrace();
           }
           len = len >= 6 ? len : 6;
           String randomPassword = getRandomPassword(len);
           t1.setText(randomPassword);
       }
       if(text.equals("�������¼")){
           File file = new File("Password.txt");
           try {
               Desktop.getDesktop().open(file);
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }

    }

    //��ȡ�������
    public static String getRandomPassword(int len) {
        String result = null;
        len = len >= 6 ? len : 6;
        while (true){
            result = makeRandomPassword(len);
            if (result.matches(".*[a-z]{1,}.*") && result.matches(".*[A-Z]{1,}.*") && result.matches(".*\\d{1,}.*") && result.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
                return result;
            }
        }
    }

    //�����������
    public static String makeRandomPassword(int len) {
        char charArr [] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charArr[r.nextInt(charArr.length)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PasswordUtil frame = new PasswordUtil();
        frame.init();
    }


}