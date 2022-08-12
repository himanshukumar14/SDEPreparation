package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
 * 
 * There are N circles such that their centers are inside the rectangle.
 * 
 * Radius of each circle is R. Now we need to find out if it is possible that we
 * can move from (0, 0) to (x, y) without touching any circle.
 * 
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we
 * cannot move outside the boundary of the rectangle at any point of time.
 * 
 * 
 * 
 * Problem Constraints 0 <= x , y, R <= 100
 * 
 * 1 <= N <= 1000
 * 
 * Center of each circle would lie within the grid
 * 
 * 
 * 
 * Input Format 1st argument given is an Integer x , denoted by A in input.
 * 
 * 2nd argument given is an Integer y, denoted by B in input.
 * 
 * 3rd argument given is an Integer N, number of circles, denoted by C in input.
 * 
 * 4th argument given is an Integer R, radius of each circle, denoted by D in
 * input.
 * 
 * 5th argument given is an Array A of size N, denoted by E in input, where A[i]
 * = x cordinate of ith circle
 * 
 * 6th argument given is an Array B of size N, denoted by F in input, where B[i]
 * = y cordinate of ith circle
 * 
 * 
 * 
 * Output Format Return YES or NO depending on weather it is possible to reach
 * cell (x,y) or not starting from (0,0).
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * x = 2 y = 3 N = 1 R = 1 A = [2] B = [3] Input 2:
 * 
 * x = 1 y = 1 N = 1 R = 1 A = [1] B = [1]
 * 
 * 
 * Example Output Output 1:
 * 
 * NO Output 2:
 * 
 * NO
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * There is NO valid path in this case Explanation 2:
 * 
 * There is NO valid path in this case
 *
 */

public class ValidPathOverCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solve(int A, int B, int C, int D, int[] E, int[] F) {
		int[][] visited = new int[A + 1][B + 1];
		for (int i = 0; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				for (int k = 0; k < C; ++k) {
					if (Math.sqrt(Math.pow(E[k] - i, 2) + Math.pow(F[k] - j, 2)) <= D) {
						visited[i][j] = 1;
						break;
					}
				}
			}
		}

		if (visited[0][0] == 1 || visited[A][B] == 1)
			return "NO";

		int[] a1 = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] a2 = new int[] { 1, -1, 1, 0, -1, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = 1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			visited[curr[0]][curr[1]] = 1;
			if (curr[0] == A && curr[1] == B)
				return "YES";

			for (int k = 0; k < 8; ++k) {
				int x = curr[0] + a1[k];
				int y = curr[1] + a2[k];
				if (x >= 0 && x <= A && y >= 0 && y <= B && visited[x][y] == 0) {
					q.add(new int[] { x, y });
				}
			}
		}
		return "NO";
	}

}
