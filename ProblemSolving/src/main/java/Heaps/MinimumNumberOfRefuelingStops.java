package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * A car travels from a starting position to a destination which is target miles
 * east of the starting position.
 * 
 * There are gas stations along the way. The gas stations are represented as an
 * array stations where stations[i] = [positioni, fueli] indicates that the ith
 * gas station is positioni miles east of the starting position and has fueli
 * liters of gas.
 * 
 * The car starts with an infinite tank of gas, which initially has startFuel
 * liters of fuel in it. It uses one liter of gas per one mile that it drives.
 * When the car reaches a gas station, it may stop and refuel, transferring all
 * the gas from the station into the car.
 * 
 * Return the minimum number of refueling stops the car must make in order to
 * reach its destination. If it cannot reach the destination, return -1.
 * 
 * Note that if the car reaches a gas station with 0 fuel left, the car can
 * still refuel there. If the car reaches the destination with 0 fuel left, it
 * is still considered to have arrived.
 *
 */

public class MinimumNumberOfRefuelingStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int n = stations.length;
		int stops = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});

		int i = 0;
		int dist = startFuel;
		while (i < n) {
			if (stations[i][0] <= dist) {
				pq.add(stations[i++]);
			} else if (pq.isEmpty() && stations[i][0] > dist) {
				return -1;
			} else {
				while (!pq.isEmpty() && dist < stations[i][0]) {
					stops++;
					dist += pq.poll()[1];
				}
			}
		}

		while (n > 0 && !pq.isEmpty() && dist < target) {
			stops++;
			dist += pq.poll()[1];
		}
		return dist >= target ? stops : -1;
	}
}
