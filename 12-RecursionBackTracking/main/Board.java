package main; 

public class Board {

	// board marking all set pieces by true
	boolean field[][];

	// size of board
	static final int size = 8;

	// constructor, generates empty board of given size
	Board() {
		field = new boolean[size][];
		for (int i = 0; i < size; i++)
			field[i] = new boolean[size];
		for (int y = 0; y < size; y++)
			for (int x = 0; x < size; x++)
				field[y][x] = false;
	}

	/** returns true if in no row, column or diagonal there are more than one piece */ 
	boolean testBoard() {
		// test horizontally
		for (int y = 0; y < size; y++) {
			int cnt = 0;
			for (int x = 0; x < size; x++)
				if (field[y][x])
					cnt++;
			if (cnt >= 2)
				return false;
		}
		
		// test vertically
		for (int x = 0; x < size; x++) {
			int cnt = 0;
			for (int y = 0; y < size; y++)
				if (field[y][x])
					cnt++;
			if (cnt >= 2)
				return false;
		}

		// test diagonal 1
		for (int xs = -size; xs < size; xs++) {
			int cnt = 0;
			for (int y = 0; y < size; y++) {
				int x = xs + y;
				if ((x >= 0) && (x < size) && (y >= 0) && (y <= size)) {
					if (field[y][x])
						cnt++;
				}
			}
			if (cnt >= 2)
				return false;
		}
		// test diagonal 2
		for (int xs = 0; xs < 2*size; xs++) {
			int cnt = 0;
			for (int y = 0; y < size; y++) {
				int x = xs - y;
				if ((x >= 0) && (x < size) && (y >= 0) && (y <= size)) {
					if (field[y][x])
						cnt++;
				}
			}
			if (cnt >= 2)
				return false;
		}
		return true;
	}

	
	void enumerateBoards(int n, int[] pos) {
		if (n >= size) {
			for (int i = 0; i < size; i++)
				System.out.print(pos[i] + " ");
			System.out.println();
			return;
		}

		for (int x = 0; x < size; x++) {
			// set Queen
			field[n][x] = true;
			// check we don't violate the rules
			if (testBoard()) {
				pos[n] = x;
				enumerateBoards(n + 1, pos);
			}
			// delete Queen
			field[n][x] = false;
		}
	
	}

	public static void main(String[] args) {

		Board b = new Board();

		int[] pos = new int[size];

		b.enumerateBoards(0, pos);

		System.out.println("done");
	}


}
