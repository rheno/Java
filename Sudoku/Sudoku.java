import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;


class SudokuSolver {

	int[][] matrix;
	int col, row;

	public SudokuSolver(int[][] m) {
		matrix = m;
	}
	
	/* Check if matrix is already filled all */
	private boolean isFull(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matrix[i][j] == 0){
					row = i;
					col = j;
					return false;
				}
			}
		}
		
		return true;
	}

	/* Check if there is no same number in vertical and horizontal position */
	public boolean isSafe(int x, int y, int value) {

		// Check Horizontal
		for (int i = 0; i < 9; i++) {
			if (i != y && matrix[row][i] == value) {
				return false;
			}
		}

		// Check Vertical
		for (int i = 0; i < 9; i++) {
			if (i != x && matrix[i][col] == value) {
				return false;
			}
		}

		return true;

	}

	/* Solution */
	public boolean solve() {
		int curRow, curCol;
		curRow = row;
		curCol = col;
		
		if (isFull()) {
			return true;
		}

		for(int i=1;i<=9;i++){
			if(isSafe(row, col, i)){
				matrix[row][col] = i;
				if(solve()){
					return true;
				}
				matrix[row][col] = 0;
			}
		}
		
		
		matrix[curRow][curCol] = 0;
		
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


			if (s.solve()) {
				s.printResult();
			} else {
				System.out.println("Solution not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
