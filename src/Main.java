import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] mat = randomizeMatrix();
        printMatrix(mat);
        printMatrix(binSort(mat));

    }

    public static int[][] randomizeMatrix() {
        Random rand = new Random();
        int[][] randMatrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                randMatrix[i][j] = rand.nextInt(89) + 10; // couldn't find lower bound definition
            }
        }
        return randMatrix;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // not space efficient, but should be on the faster side
    public static int[][] binSort(int[][] mat) {
        int[][] intCount = new int[9][10]; // a matrix storing count of every integer from 10 to 99 inclusive
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int n = mat[i][j];
                intCount[n / 10 - 1][n % 10]++; // 10s are rows, singles are columns
            }
        }
        int[][] sortedMat = new int[10][10];
        int c = 0; // sorted matrix counter
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                while (intCount[i][j] > 0) {
                    sortedMat[c / 10][c % 10] = (i + 1) * 10 + j;
                    c++;
                    intCount[i][j]--;
                }
            }
        }
        return sortedMat;
    }
}
