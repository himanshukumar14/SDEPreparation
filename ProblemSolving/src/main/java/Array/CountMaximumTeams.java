package Array;

import java.util.Arrays;

/**
 * 
 * Amazon is hosting a team hackathon.
 * 
 * Each team will have exactly teamSize developers. A developer�s skill level is
 * denoted by skill[i]. The difference between the maximum and minimum skill
 * levels within a team cannot exceed a threshold, maxDiff. Determine the
 * maximum number of teams that can be formed from the contestants. Example
 * skill = [3, 4, 3, 1, 6, 5] team5ize = 3 maxDiff = 2
 * 
 * At most, 2 teams can be formed: [3, 3, 1] and [4, 6, 5]. The difference
 * between the maximum and minimum skill levels is 2 in each case, which does
 * not exceed the threshold value oft.
 * 
 * Function Description Complete the function countMaximumTeams in the editor
 * below.
 * 
 * countMaximumTeams has the following parameter(s):
 * 
 * int skill[n]: the developers skill levels int teamSize: the number of
 * developers to make up a team int maxDiff: the threshold value Returns:
 * 
 * int: the maximum number of teams that can be formed at one time
 * 
 */

public class CountMaximumTeams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] skills = new int[] {3,4,3,1,6,5};
		int teamSize = 3;
		int maxDiff = 1;
		System.out.println(countMaxTeams(skills, teamSize, maxDiff));
	}

	public static int countMaxTeams(int[] skills, int teamSize, int maxDiff) {
		int n = skills.length;
		Arrays.sort(skills);
		int max = 0;
		int i = 0;
		int j = teamSize - 1;
		while (j < n) {
			int diff = skills[j] - skills[i];
			if (diff > maxDiff) {
				i++;
				j++;
			} else {
				max++;
				i = j + 1;
				j = j + teamSize;
			}
		}
		return max;
	}

}
