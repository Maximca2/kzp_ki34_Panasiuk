package lab2;

import java.io.*;
import java.util.Scanner;
/**
 * @author Panasyuk Maksym КІ-34
 * @version 1.0
 * @since version 1.0
 */
public class Lab2PanasyukKI34 {

    /**
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws Exception {
        int nRows;
        boolean half = false;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();

        if(nRows < 4) {
            throw new Exception("Мінімальний розмір матриці - 4");
        }

        arr = new char[nRows][];
        String sp = "";
        for (int i = 0; i < nRows/2; i++){
            sp += "  ";
        }
        int row = 0;
        int x = -1;
        int y = 0;
        while(y < nRows / 2){
            arr[y] = new char[x+2];
            x+=2;
            y+=1;
        }
        while(x > 2 & y < nRows){
            arr[y] = new char[x-2];
            x-=2;
            y+=1;
        }

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        int c = nRows % 3;
        int wallLength = (nRows - c) / 3;
        int gapLength = wallLength + c;
        int middleLayerLength = nRows - wallLength * 2;


        for (int i = 0; i < wallLength; i++)
        {
            for (int j = 0; j < nRows; j++) {
                System.out.print((char) filler.codePointAt(0) + " ");
                fout.print((char) filler.codePointAt(0) + " ");
            }
            System.out.print('\n');
            fout.print('\n');
        }


        for (int i = 0; i < middleLayerLength; i++)
        {
            for(int j = 0; j < wallLength; j++) {
                System.out.print((char) filler.codePointAt(0) + " ");
                fout.print((char) filler.codePointAt(0) + " ");
            }
            for(int j = 0; j < gapLength; j++) {
                System.out.print("  ");
                fout.print("  ");
            }
            for(int j = 0; j < wallLength; j++) {
                System.out.print((char) filler.codePointAt(0) + " ");
                fout.print((char) filler.codePointAt(0) + " ");
            }
            System.out.print('\n');
            fout.print('\n');
        }


        for (int i = 0; i < wallLength; i++)
        {
            for (int j = 0; j < nRows; j++) {
                System.out.print((char) filler.codePointAt(0) + " ");
                fout.print((char) filler.codePointAt(0) + " ");
            }
            System.out.print('\n');
            fout.print('\n');
        }

        fout.flush();
        fout.close();
    }
}