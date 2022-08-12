package Array;

/**
 * 
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.
 * Note that:
 * 
 * The north direction is the positive direction of the y-axis. The south
 * direction is the negative direction of the y-axis. The east direction is the
 * positive direction of the x-axis. The west direction is the negative
 * direction of the x-axis. The robot can receive one of three instructions:
 * 
 * "G": go straight 1 unit. "L": turn 90 degrees to the left (i.e.,
 * anti-clockwise direction). "R": turn 90 degrees to the right (i.e., clockwise
 * direction). The robot performs the instructions given in order, and repeats
 * them forever.
 * 
 * Return true if and only if there exists a circle in the plane such that the
 * robot never leaves the circle.
 *
 */

public class RobotBoundedInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Intuition Let chopper help explain.
	 * 
	 * Starting at the origin and face north (0,1), after one sequence of
	 * instructions,
	 * 
	 * if chopper return to the origin, he is obvious in an circle. if chopper
	 * finishes with face not towards north, it will get back to the initial status
	 * in another one or three sequences.
	 * 
	 */

	public boolean isRobotBounded(String instructions) {
		// 0 - North
		// 1 - East
		// 2 - South
		// 3 - West

		int x = 0;
		int y = 0;
		int dir = 0;
		int[][] path = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int n = instructions.length();

		for (int i = 0; i < n; ++i) {
			char ch = instructions.charAt(i);
			if (ch == 'L')
				dir = (dir + 3) % 4;
			else if (ch == 'R')
				dir = (dir + 1) % 4;
			else if (ch == 'G') {
				x += path[dir][0];
				y += path[dir][1];
			}
		}
		return (x == 0 && y == 0) || dir > 0;
	}

}
