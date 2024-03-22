!! add package

import java.util.Arrays;
import java.util.Random;

public class Main { !! change name
    public static void main(String[] args) {
        int[][] mat = randomizeMatrix();
        System.out.println("Original randomized matrix:");
        printMatrix(mat);
        System.out.println("Matrix sorted through bins:");
        printMatrix(binSort(mat)); !!! binSort - koshmariki esli 4esno, esli tisala sama tebe plusik v karmu, esli net - a smysl? davay pusyrkom perepishem

    }

    public static int[][] randomizeMatrix() {
        int[][] randMatrix = new int[10][10];
        Random rand = new Random(); !! not create every time, use one instance & initialize with seed - new Random(System.currentTimeMillis())
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                randMatrix[i][j] = rand.nextInt(89) + 10; // couldn't find lower bound definition !!! magic numbers - introduce constants
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

    // doesn't quite work, still needs debugging
    public static void quickSort(int[][] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[][] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[][] arr, int begin, int end) {
        int pivot = arr[end / 10][end % 10];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j / 10][j % 10] <= pivot) {
                i++;

                int swapTemp = arr[i / 10][i % 10];
                arr[i / 10][i % 10] = arr[j / 10][j % 10];
                arr[j / 10][j % 10] = swapTemp;
            }
        }

        int swapTemp = arr[(i+1) / 10][(i+1) % 10];
        arr[(i+1) / 10][(i+1) % 10] = arr[end / 10][end % 10];
        arr[end / 10][end % 10] = swapTemp;
        return i+1;
    }

}
