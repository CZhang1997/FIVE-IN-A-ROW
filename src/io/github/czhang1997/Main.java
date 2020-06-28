package io.github.czhang1997;

import io.github.czhang1997.FIR.FIR;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FIR fir = new FIR();
        Scanner scanner = new Scanner(System.in);

        System.out.println("GAME --------- FIVE IN A ROW ---------- START");
        int row = -1;
        int col = -1;
        while(!fir.gameOver(row, col))
        {

            System.out.println("Here is the board: ");
            System.out.println(fir);
            System.out.print((fir.getTurn() == FIR.BLACK ? "BALCK" : "WHITE") + ": Enter the row and col to place a chess on the board: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if(!fir.placeChess(row, col))
            {
                System.out.println("InValid location, please try again");
            }
        }
        System.out.println(fir);
        if(fir.getWinner() == FIR.BLACK)
        {
            System.out.println("BLACK WINS");
        }
        else
        {
            System.out.println("WHITE WINS");
        }
    }
}
