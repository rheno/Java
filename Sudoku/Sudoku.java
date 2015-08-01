import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;


class SudokuSolver {

	int[][] matrix;

	public SudokuSolver(int[][] m) {
		matrix = m;
	}

	/* Check if position matrix safe */
	private boolean isSafe(int x, int y) {
		if (x < 0 || y < 0) {
			return false;
		} else if (x >= 9 || y >= 9) {
			return false;
		}
		return true;
	}

	/* Check if position and value is safe to filled */
	public int filled(int x, int y, int value) {

		// Check Horizontal
		for (int i = 0; i < 9; i++) {
			if (i != y && matrix[x][i] == value) {
				return 0;
			}
		}

		// Check Vertical
		for (int i = 0; i < 9; i++) {
			if (i != x && matrix[i][y] == value) {
				return 0;
			}
		}

		return value;

	}

	/* Solve the problem */
	public boolean solve(int x, int y) {

		if (matrix[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (filled(x, y, i) != 0) {
					matrix[x][y] = i;
					break;
				}
			}
		}

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				if (matrix[i][j] == 0) {
					return solve(i, j);
				}
			}
		}


		if (matrix[x][y] != 0) {
			return true;
		}



		matrix[x][y] = 0;



		return false;
	}

	/* Print the matrix */
	public void printResult() {
		for (int i = 0; i < 9; i++) {
			System.out.println("\n");
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
		}
	}

}



public class Sudoku {

	public static void main(String[] args) {

		try {

			//System.setIn(new FileInputStream(new File("input.txt")));
			//System.setOut(new PrintStream(new File("output.txt")));
			Scanner sc = new Scanner(System. in );
			int[][] matrix = new int[9][9];


			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			SudokuSolver s = new SudokuSolver(matrix);


			if (s.solve(0, 0)) {
				s.printResult();
			} else {
				System.out.println("Solution not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
