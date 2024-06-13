package main;

public class Labyrinth {
	static final int START_NODE =  1;
	static final int EXIT_NODE  = 21;
	
	
	
	static boolean[] isVisitedNode = new boolean[26];
	static int[][]   edge          = new int[][] {
		{},
		{ 2        }, { 1,  7    }, { 8            }, { 5        }, { 4, 10    },
		{11        }, { 2, 12,  8}, { 3,  9, 13,  7}, { 8, 10    }, { 5,  9, 15},
		{ 6, 16, 12}, { 7, 11    }, { 8, 18        }, {19        }, {10, 20    },
		{11        }, {18, 22    }, {13, 17, 19    }, {14, 18, 24}, {15, 25    },
		{22        }, {17, 21, 23}, {22            }, {19        }, {20        }};

	
   public static void main(String[] args) {
		searchPath(START_NODE);
	}  // end main

	// True if path has been found
	static boolean searchPath(int node) {
		if (isVisitedNode[node])  // node has been checked already
			return false;
		else {
			isVisitedNode[node] = true;
			
			if (node == EXIT_NODE) {
				System.out.println("Ausgang (exit) erreicht");
				System.out.print(node + " ");
				return true;		  // Goal achieved; starte 'Aufstieg'
			}
			else {
				int[] nextNodes = edge[node];
			
				for (int i = 0; i < nextNodes.length; i++) {
					// How many calls of search path in stack will we have when we are on the correct path?
					if (searchPath(nextNodes[i])) {
						// what will be the first node printed?
						System.out.print(node + " ");
						return true;  // Ziel erreicht; 'Aufstieg'
					}
				}
				return false;         // All nextNodes blocked, cul de sac ==> Backtracking
			}
		}
	} 
}  
