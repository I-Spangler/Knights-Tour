package com.tp1;

import java.util.Random;

public class Horse {

    private int[] pos;
    private int stepLimit;
    public int[][] LogMatrix;

    private int[] choose_initial_position() {
        Random r = new Random();
        int s = r.nextInt(64);
        int row = s / 8;
        int column = (s % 8);
        int[] pos = new int[2];
        System.out.println("init-pos: " + String.valueOf(row) + " _ " + String.valueOf(column));
        pos[0] = row;
        pos[1] = column;
        this.pos = pos;
        return pos;
    }

    private int[][] get_possible_next_moves(int[] pos) {
        //the next moves will always be like "column/row +- 1, +- 2"
        int[][] moves = {{pos[0] + 1, pos[1] + 2},
                {pos[0] + 1, pos[1] - 2},
                {pos[0] - 1, pos[1] + 2},
                {pos[0] - 1, pos[1] - 2},
                {pos[0] + 2, pos[1] + 1},
                {pos[0] + 2, pos[1] - 1},
                {pos[0] - 2, pos[1] + 1},
                {pos[0] - 2, pos[1] - 1}};

        return moves;
    }

    private boolean already_visited(int[] pos) {
        if (this.LogMatrix[pos[0]][pos[1]] != 0) {
            return true;
        }
        return false;
    }

    private boolean is_valid(int[] pos) {

        if (pos[0] >= 8 || pos[0] < 0 || pos[1] >= 8 || pos[1] < 0) {
            return false;
        }
        return true;
    }

    //main recursive method, gets a position and fills the log matrix
    private boolean visit(int[] pos, int step) {

        int[][] candidates;
        int i = 0;
        boolean completed_way = false;

        //take the step
        this.LogMatrix[pos[0]][pos[1]] = step;
        //if the horse completed the board
        if (step == this.stepLimit)
            return true;

        candidates = this.get_possible_next_moves(pos);
        while (i < 8) {
            if (this.is_valid(candidates[i]) && !this.already_visited(candidates[i]))
                completed_way = this.visit(candidates[i], step + 1);
            if (completed_way)
                return true;
            i++;
        }
        this.LogMatrix[pos[0]][pos[1]] = 0;
        return false;
    }

    //public caller function
    public int[][] run(int n) {
        this.stepLimit = n;
        int[] starting_point = this.choose_initial_position();
        int i, j;
        this.LogMatrix = new int[8][8];
        boolean result;
        result = this.visit(pos, 1);
        return LogMatrix;
    }

}
