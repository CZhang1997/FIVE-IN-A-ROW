package io.github.czhang1997.FIR;

public class FIR {
    public static final int SIZE = 17;
    public static final int EMPTY = 0;
    public static final int BLACK = 1;
    public static final int WHITE = 2;

    public static final String [] SYMBOL = {" ", "B", "W"};
                                            //      0       1       2         3        4       5       6       7
    public static final int [][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private int [][] board;
    private int turn;
    private int winner;

    public FIR() {
        board = new int[SIZE][SIZE];
        turn = BLACK;
    }

    public boolean placeChess(int row, int col) {
        if(checkPlaceAble(row, col))
        {
            board[row][col] = turn;
            turn = (turn == BLACK ? WHITE : BLACK);
            return true;
        }
        else
            return false;
    }
    public boolean gameOver(int row, int col) {
        if(!checkIfInRange(row, col))
            return false;
        int previousTurn = board[row][col];
        int end = 7;
        for(int start = 0; start < DIRECTIONS.length / 2; start ++)
        {
            int count = 1;  // the current chess
            count += getCountInDirection(row, col, previousTurn, start); // direction in front of center
            count += getCountInDirection(row, col, previousTurn, end); // direction in the back of center
            if(count >= 5){
                winner = previousTurn;
                return true;
            }
            end --;
        }
        return false;
    }
    private int getCountInDirection(int row, int col, int value, int direction) {
        row += DIRECTIONS[direction][0];
        col += DIRECTIONS[direction][1];
        if(checkIfInRange(row, col))
        {
            if(board[row][col] == value)
            {
                return 1 + getCountInDirection(row, col, value, direction);
            }
        }
        return 0;
    }
    private boolean checkPlaceAble(int row, int col) {
        if(checkIfInRange(row, col) && board[row][col] == EMPTY)
            return true;
        return false;
    }
    private boolean checkIfInRange(int row, int col) {
        if(row < 0 || row >= SIZE || col < 0 || col >= SIZE)
        {
            return false;
        }
        return true;
    }
    public String toString() {
        String ret = "";
        for(int row = 0; row < SIZE; row ++)
        {
            for(int col = 0; col < SIZE; col ++)
            {
                ret += SYMBOL[board[row][col]] + " ";
            }
            ret += "\n";
        }
        return ret.substring(0, ret.length() - 1);
    }
    public int getTurn() {
        return turn;
    }
    public int getWinner() {
        return winner;
    }
}
