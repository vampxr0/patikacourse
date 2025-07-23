package week1.matrixtranspose;

import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in); // Kullanıcıdan matrixin ölçülerini alır ve tanımlar.


        System.out.println("Matrixiniz kaç satır? ");
        int row = scan.nextInt();
        System.out.println("Matrixiniz kaç sütun? ");
        int column = scan.nextInt();

        int[][] matrix = new int[row][column]; // İki çeşit matriximiz olduğu için iki tane 2 boyutlu dizi tanımlar.
        int[][] transpose = new int[column][row];

        System.out.println("Matrixin elemanlarını giriniz.");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++){
                System.out.println("Matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scan.nextInt();
            }
            
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Matrix: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }

        System.out.println("Transpoze: ");   // Matrixin transpoze çıktısı için.
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(transpose[i][j] + "    ");
            }
            System.out.println();
        }

        scan.close();
    }
}