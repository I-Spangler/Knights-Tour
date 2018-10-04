package com.tp1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Numero de passos não especificado");
            System.exit(1);
            return;
        }
        int stepLimit = Integer.parseInt(args[0]);

        int[][] result;

        JFrame f = new JFrame("TP1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(800, 800);

        Horse h = new Horse();
        Chessboard c = new Chessboard();
        c.setLayout(null);

        result = h.run(stepLimit);
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 8; j += 1) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        c.BoardMatrix = result;

        f.add(c);

    }
}
