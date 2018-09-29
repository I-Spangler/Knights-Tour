package com.tp1;

import java.awt.*;
import javax.swing.*;

public class Chessboard extends JPanel {

    public int[][] BoardMatrix = new int[8][8];

    public void paintComponent(Graphics g) {
        boolean sem = false;

        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        System.out.println("AAAAA");
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 8; j += 1) {
                if (sem)
                    g.fillRect(i * 80, j * 80, 80, 80);
                sem = !sem;
                JLabel jlabel = new JLabel(String.valueOf(this.BoardMatrix[i][j]));
                jlabel.setFont(new Font("Verdana", 1, 30));
                jlabel.setForeground(Color.RED);
                jlabel.setBounds((i * 80) + 20, (j * 40), i * 80 + 80, j * 80 + 80);
                this.add(jlabel);
            }
            sem = !sem;
        }
    }
}
