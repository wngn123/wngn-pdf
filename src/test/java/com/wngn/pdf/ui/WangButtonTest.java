package com.wngn.pdf.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class WangButtonTest {

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 400, 300);
        //WangButton button = WangButton.getForbidButon("提交");
        WangButton button =WangButton.getActiveButon("提交");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("999999999999999");

            }
        });
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(button);

        jframe.getContentPane().setBackground(Color.WHITE);
        jframe.setVisible(true);
    }

}
