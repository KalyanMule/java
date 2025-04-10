import java.util.Random;
import java.util.Scanner;

public class Complex {
    private static int size;
    private static int[][] grid;
    private static int[][] solution;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Sudoku grid size: ");
        size = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter difficulty level (Low, Medium, High): ");
        String level = scanner.nextLine().toLowerCase();

        grid = new int[size][size];
        generateSudoku(grid, size);
        solution = copyGrid(grid);

        removeNumbers(grid, size, level);

        printGrid(grid, size);
        userInput(grid, size);
        checkSolution(grid, size);

        scanner.close();
    }

    public static void generateSudoku(int[][] grid, int size) {
        Random random = new Random();
        int[] numbers = new int[size];

        // Fill the first row with shuffled numbers
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
        shuffleArray(numbers, random);
        System.arraycopy(numbers, 0, grid[0], 0, size);

        // Fill the rest of the grid
        fillGrid(grid, 0, 0, size);
    }

    private static boolean fillGrid(int[][] grid, int row, int col, int size) {
        if (row == size) {
            return true;
        }
        if (col == size) {
            return fillGrid(grid, row + 1, 0, size);
        }
        if (grid[row][col] != 0) {
            return fillGrid(grid, row, col + 1, size);
        }

        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
        shuffleArray(numbers, random);

        for (int num : numbers) {
            if (isValid(grid, row, col, num, size)) {
                grid[row][col] = num;
                if (fillGrid(grid, row, col + 1, size)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isValid(int[][] grid, int row, int col, int num, int size) {
        for (int i = 0; i < size; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    public static void removeNumbers(int[][] grid, int size, String level) {
        Random random = new Random();
        int cellsToRemove;

        switch (level) {
            case "low":
                cellsToRemove = size;
                break;
            case "medium":
                cellsToRemove = (size * size) - (size * size / 3);
                break;
            case "high":
                cellsToRemove = (size * size) - 1;
                break;
            default:
                cellsToRemove = (size * size) - (size * size / 3);
        }

        while (cellsToRemove > 0) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            if (grid[i][j] != 0) {
                grid[i][j] = 0;
                cellsToRemove--;
            }
        }
    }

    public static void printGrid(int[][] grid, int size) {
        int maxDigit = String.valueOf(size).length();
        int cellWidth = maxDigit + 2;

        StringBuilder s = new StringBuilder(".");
        for (int i = 0; i < size; i++) {
            s.append("-".repeat(cellWidth)).append(".");
        }
        String s1 = s.toString();
        System.out.println(s1);

        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                String str = (grid[i][j] == 0 ? " ".repeat(maxDigit) : String.format("%" + maxDigit + "d", grid[i][j]));
                System.out.print(" " + str + " |");
            }
            System.out.println();
            System.out.println(s1);
        }
    }

    public static void userInput(int[][] grid, int size) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("Enter value for row " + (i + 1) + ", column " + (j + 1) + ": ");
                    grid[i][j] = scanner.nextInt();
                    printGrid(grid, size);
                }
            }
        }
        scanner.close(); // Closing scanner here to avoid errors
    }

    public static void checkSolution(int[][] grid, int size) {
        if (isValidSolution(grid, size)) {
            System.out.println("Congratulations! You solved the Sudoku.");
        } else {
            System.out.println("Oops! Your answer is incorrect.");
        }
    }

    public static boolean isValidSolution(int[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];

            for (int j = 0; j < size; j++) {
                int rowNum = grid[i][j];
                int colNum = grid[j][i];

                if (rowNum < 1 || rowNum > size || rowCheck[rowNum]) {
                    return false;
                }
                if (colNum < 1 || colNum > size || colCheck[colNum]) {
                    return false;
                }
                rowCheck[rowNum] = true;
                colCheck[colNum] = true;
            }
        }
        return true;
    }

    public static int[][] copyGrid(int[][] original) {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, size);
        }
        return copy;
    }

    private static void shuffleArray(int[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}

