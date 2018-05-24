// ****************************************************************
// MagicSquare.java
// Lab number: 4
// Author name: Irina Molitvenik
// This program checks if this is a magic square 
// Date: 2/21/2018
//****************************************************************
import java.util.Scanner;
public class MagicSquare { 

    private int square[][];

    public MagicSquare(int size)
    {
       square = new int[size][size];     
    }
//--------------------------------------
//return the sum of the values in the given row
//--------------------------------------
 
    private int sumMagicRow(int row)
    {
      int sum = 0;
      for(int i = 0; i < square.length; i++)
      {
         sum = sum + square[row][i];
      }
      return sum;
    }
//--------------------------------------
//return the sum of the values in the given column
//--------------------------------------
 
    private int sumMagicCol(int col)
    {
      int sum = 0;
      for(int i = 0; i < square.length; i++)
      {
         sum = sum + square[i][col];
      }
      return sum;
    }
//--------------------------------------
//return the sum of the values in the main diagonal
//--------------------------------------
 
    private int sumMagicDiagMain()
    {
      int sum = 0;
      for(int i = 0; i < square.length; i++)
      {
         sum = sum + square[i][i];
      }
      return sum;
    }
//--------------------------------------
//return the sum of the values in the other ("reverse") diagonal
//--------------------------------------
 
    private int sumMagicDiagRev()
    {
      int sum = 0;
      int row = 0;
      for(int col = square.length - 1; col >= 0; col--)
      {
         sum = sum + square[row][col];
         row++;
      }
      return sum;
    }
 
//--------------------------------------
//return true if the square is magic (all rows, cols, and diags
// have same sum), false otherwise
//-------------------------------------- 
    public boolean isMagicSquare()
    {
       boolean answer = true;
       int row = 0;
       int col = 0;
       int diagMain = 0;
       int diagRev = 0;
       for(int i = 0; i < square.length - 1; i++)
       {
         row = sumMagicRow(i);
         col = sumMagicCol(i);
         diagMain = sumMagicDiagMain();
         diagRev = sumMagicDiagRev();
         if(!(row == col && row == diagMain && row == diagRev))
         {
            answer = false;
         }
       }  
       return answer;
    }
//--------------------------------------
//compute and display sums of square including row, column, main diagonal, and other diagonal
//--------------------------------------
    public void printMagicSquareSums()
    {
      for(int i = 0; i < square.length; i++)
      {
         int row = sumMagicRow(i);
         System.out.println("Sum of row " + i + "is: " + row);
      }
      System.out.print("\n");
      for(int c = 0; c < square.length - 1; c++)
      {
         int col = sumMagicCol(c);
         System.out.println("Sum of column " + c + "is: " + col);
      }
      System.out.print("\n");
      int diagMain = sumMagicDiagMain();
      System.out.println("The sum of the main diagonal is: " + diagMain);
      int diagRev = sumMagicDiagRev();
      System.out.println("The sum of the other diagonal is: " + diagRev);
      System.out.print("\n");
    }

//--------------------------------------
//read info into the square from the input stream associated with
//the Scanner parameter
//--------------------------------------
    public void readSquare(Scanner scan)
    {
        for (int row = 0; row < square.length; row++)
           for (int col = 0; col < square.length; col++)
              square[row][col] = scan.nextInt();
    }
//--------------------------------------
//print the contents of the square, neatly formatted
//--------------------------------------
    public void printSquare()
    {
      for(int c = 0; c < square.length; c++)
      {
         for(int r = 0; r < square.length; r++)
         {
            System.out.print(square[c][r] + " ");
         }
         System.out.print("\n");
      }
    }          
}