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
        winner = -1;
    }

    public boolean placeChess(int row, int col) {
        // check if the location can place a chess
        if(checkPlaceAble(row, col))
        {
            board[row][col] = turn; // place the chess
            turn = (turn == BLACK ? WHITE : BLACK); // change the turn to the other player
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
            if(count >= 5){ // check if in the one direction has more than 5 chess of the same type
                winner = previousTurn;
                return true;
            }
            end --;
        }
        return false;
    }
    private int getCountInDirection(int row, int col, int value, int direction) {
        // change the coordinate to that direction
        row += DIRECTIONS[direction][0];
        col += DIRECTIONS[direction][1];
        if(checkIfInRange(row, col))
        {
            if(board[row][col] == value)    // this value is the same type then check next
            {
                return 1 + getCountInDirection(row, col, value, direction); // go on with that direction
            }
        }
        return 0;
    }
    private boolean checkPlaceAble(int row, int col) {
        return checkIfInRange(row, col) && board[row][col] == EMPTY;
    }
    private boolean checkIfInRange(int row, int col) {
        return !(row < 0 || row >= SIZE || col < 0 || col >= SIZE);
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
