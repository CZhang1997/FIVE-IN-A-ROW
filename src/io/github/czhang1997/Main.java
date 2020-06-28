package io.github.czhang1997;

import io.github.czhang1997.FIR.FIR;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FIR fir = new FIR();
        Scanner scanner = new Scanner(System.in);

        System.out.println("GAME --------- FIVE IN A ROW ---------- START");
        int row = 0;
        int col = 0;
        int turn = FIR.BLACK;
        while(!fir.gameOver(row, col))
        {
            System.out.println("Here is the board: ");
            System.out.println(fir);
            if(turn == FIR.BLACK)
            {
                System.out.print("Black: Enter the row and col to place a chess on the board: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if(fir.blackPlaceChess(row, col))
                {
                    turn = FIR.WHITE;
                }
                else
                {
                    System.out.println("InValid location, please try again");
                }
            }
            else
            {
                System.out.print("White: Enter the row and col to place a chess on the board: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if(fir.whitePlaceChess(row, col))
                {
                    turn = FIR.BLACK;
                }
                else
                {
                    System.out.println("InValid location, please try again");
                }
            }
        }
        if(turn == FIR.BLACK)
        {
            System.out.println("BLACK WINS");
        }
        else
        {
            System.out.println("WHITE WINS");
        }
    }
}
