import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;

        System.out.print("Введите ширину матрицы: ");
        width = scanner.nextInt();

        System.out.print("Введите высоту матрицы: ");
        height = scanner.nextInt();

        int[][] matrix;
        if (width <= MAX_SIZE && height <= MAX_SIZE) {
            System.out.println("Выберите способ создания матрицы:");
            System.out.println("1. Ввести значения с клавиатуры");
            System.out.println("2. Сгенерировать случайные значения");

            int choice = scanner.nextInt();
            if (choice == 1) {
                matrix = readMatrixFromUser(width, height, scanner);
            } else if (choice == 2) {
                matrix = generateRandomMatrix(width, height);
            } else {
                System.out.println("Некорректный выбор.");
                return;
            }

            System.out.println("Матрица:");
            printMatrix(matrix);

            int minValue = findMinValue(matrix);
            int maxValue = findMaxValue(matrix);
            double average = calculateAverage(matrix);

            System.out.println("Минимальное значение: " + minValue);
            System.out.println("Максимальное значение: " + maxValue);
            System.out.println("Среднее арифметическое: " + average);
        } else {
            System.out.println("Размер матрицы превышает максимально допустимое значение.");
        }
    }

    private static int[][] readMatrixFromUser(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];

        System.out.println("Введите значения матрицы:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] generateRandomMatrix(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMinValue(int[][] matrix) {
        int minValue = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < minValue) {
                    minValue = element;
                }
            }
        }

        return minValue;
    }

    private static int findMaxValue(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > maxValue) {
                    maxValue = element;
                }
            }
        }

        return maxValue;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        return (double) sum / count;
    }
}
