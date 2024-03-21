import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        printMatrix(randomizeMatrix());

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
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    // bin sort
}
