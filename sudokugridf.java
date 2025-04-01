import java.util.Random;
import java.util.Scanner;

class Sudoku {
    public static String displayGrid(int size, int length) {
        String[][] elements = createElement(size, length);
        StringBuilder pattern = new StringBuilder();
        int gridSize = 2 * size + 1;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        pattern.append(" "); 
                    } else {
                        pattern.append("-".repeat(length)); 
                    }
                } else {
                    if (col % 2 == 0) {
                        pattern.append("|");
                    } else {
                        int gridRow = (row - 1) / 2;
                        int gridCol = (col - 1) / 2;

                        if (gridRow < size && gridCol < size) {
                            pattern.append(elements[gridRow][gridCol]); 
                        } else {
                            pattern.append(" ".repeat(length)); 
                        }
                    }
                }
            }
            pattern.append("\n");
        }
        return pattern.toString();
    }
    public static String[][] createElement(int size, int length) {
        Random random = new Random();
        String[][] elements = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = random.nextInt(size) + 1; 
                boolean hide = random.nextBoolean(); 
                if (hide) {
                    elements[i][j] = String.format("%" + length + "s", " "); 
                } else {
                    elements[i][j] = String.format("%" + length + "d", num); 
                }
            }
        }
        return elements;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Sudoku grid size: ");
        int size = scanner.nextInt();
        int length = 2; 
        System.out.println(displayGrid(size, length)); 
        scanner.close();
    }
}

