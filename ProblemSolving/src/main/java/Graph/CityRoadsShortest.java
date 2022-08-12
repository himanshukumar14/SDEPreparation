package Graph;

/**
 * 
 * Sheldon lives in a country with A cities (numbered from 1 to A) and B
 * bidirectional roads.
 * 
 * Roads are denoted by integer array D, E and F of size M, where D[i] and E[i]
 * denotes the cities and F[i] denotes the distance between the cities.
 * 
 * Now he has many lectures to give in the city and is running short of time, so
 * he asked you C queries, for each query i, find the shortest distance between
 * city G[i] and H[i].
 * 
 * If the two cities are not connected then the distance between them is assumed
 * to be -1.
 * 
 * 
 * 
 * Problem Constraints 1 <= A <= 200
 * 
 * 1 <= B <= 200000
 * 
 * 1 <= C <= 100000
 * 
 * 1 <= F[i] <= 1000000
 * 
 * 1 <= D[i], E[i], G[i], H[i] <= A
 * 
 * 
 * 
 * Input Format First argument is an integer A. Seocnd argument is an integer B.
 * Third argument is an integer C. Fourth argument is an integer array D. Fifth
 * argument is an integer array E. Sixth argument is an integer array F. Seventh
 * argument is an integer array G. Eight argument is an integer array H.
 * 
 * 
 * 
 * Output Format Return an integer array of size C, for each query denoting the
 * shortest distance between the given two vertices. If the two vertices are not
 * connected then output -1.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = 4 B = 6 C = 2 D = [1, 2, 3, 2, 4, 3] E = [2, 3, 4, 4, 1, 1] F = [4, 1, 1,
 * 1, 1, 1] G = [1, 1] H = [2, 3] Input 2:
 * 
 * A = 3 B = 3 C = 2 D = [1, 2, 1] E = [2, 3, 3] F = [3, 1, 1] G = [2, 1] H =
 * [3, 2]
 * 
 * 
 * Example Output Output 1:
 * 
 * [2, 1] Output 2:
 * 
 * [1, 2]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Distance between (1,2) will 2 if we take path 1->4->2. Distance between (1,3)
 * will 1 if we take path 1->3. Explanation 2:
 * 
 * Distance between (2,3) will 1 if we take path 1->3. Distance between (1,2)
 * will 2 if we take path 1->3->2.
 *
 * 
 */

public class CityRoadsShortest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
		int[][] path = new int[A][A];
		for (int i = 0; i < A; ++i) {
			for (int j = 0; j < A; ++j) {
				if (i == j)
					path[i][j] = 0;
				else
					path[i][j] = -1;
			}
		}
		for (int i = 0; i < B; ++i) {
			int x = D[i] - 1;
			int y = E[i] - 1;
			if (path[x][y] == -1)
				path[x][y] = F[i];
			else
				path[x][y] = Math.min(path[x][y], F[i]);
			if (path[y][x] == -1)
				path[y][x] = F[i];
			else
				path[y][x] = Math.min(path[y][x], F[i]);
		}

		path = dist(path);
		int[] ans = new int[C];
		for (int i = 0; i < C; ++i) {
			int x = G[i] - 1;
			int y = H[i] - 1;
			ans[i] = path[x][y];
		}
		return ans;
	}

	public int[][] dist(int[][] A) {
		int n = A.length;
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (A[i][k] != -1 && A[k][j] != -1) {
						if (A[i][j] == -1 || A[i][k] + A[k][j] < A[i][j])
							A[i][j] = A[i][k] + A[k][j];
					}
				}
			}
		}
		return A;
	}

}
