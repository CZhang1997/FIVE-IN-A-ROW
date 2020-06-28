package io.github.czhang1997.FIR;

public class FIR {
    public static final int SIZE = 17;
    public static final int EMPTY = 0;
    public static final int BLACK = 1;
    public static final int WHITE = 2;
    public static final String [] SYMBOL = {"x", "B", "W"};
                                            //      0       1       2         3        4       5       6       7
    public static final int [][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private int [][] board;

    public FIR()
    {
        board = new int[SIZE][SIZE];
    }

    public boolean blackPlaceChess(int row, int col)
    {
        if(checkPlaceAble(row, col))
        {
            board[row][col] = BLACK;
            return true;
        }
        else
            return false;

    }
    public boolean whitePlaceChess(int row, int col)
    {
        if(checkPlaceAble(row, col))
        {
            board[row][col] = WHITE;
            return true;
        }
        else
            return false;
    }
    private boolean gameOver(int row, int col)
    {


        return false;
    }
//    private int getCountInDirection(int )
    private boolean checkPlaceAble(int row, int col)
    {
        if(checkIfInRange(row, col) && board[row][col] == EMPTY)
            return true;
        return false;
    }
    private boolean checkIfInRange(int row, int col)
    {
        if(row < 0 || row >= SIZE || col < 0 || col >= SIZE)
        {
            return false;
        }
        return true;
    }
    public String toString()
    {
        String ret = "";
        for(int row = 0; row < SIZE; row ++)
        {
            for(int col = 0; col < SIZE; col ++)
            {
                ret += SYMBOL[board[row][col]] + " ";
            }
            ret += "\n";
        }
        return ret;
    }
}
