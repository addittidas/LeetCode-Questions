// 51. N-Queens
/* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively. */

import java.util.*;

class Q51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        func(0, list, board);
        return list;
    }

    public void func(int col, List<List<String>> list, char[][] board){
        if (col == board.length){
            list.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(validate(board, row, col)){
            board[row][col] = 'Q';
            func(col + 1, list,board);
            board[row][col] = '.';
            }
        } 
    }

    // To store values as string
    public List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    // To check whether Queen can be placed
    public boolean validate(char [][] board, int row, int col){
        int duprow = row;
        int dupcol = col;
        while(row >= 0 && col >=0 ){
            if (board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        
        while(col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row = duprow;
        col = dupcol;
        while(col >= 0 && row < board.length){
            if (board[row][col] == 'Q'){
                return false;
            }
            col--;
            row++;
        }
        return true;
    }
}