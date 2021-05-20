package Algos;

import models.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms,
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
 * dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
 * Output: 3
 * Explanation:
 * Minimum 3 platforms are required to
 * safely arrive and depart all trains.
 * Example 2:
 *
 * Input: n = 3
 * arr[] = {0900, 1100, 1235}
 * dep[] = {1000, 1200, 1240}
 * Output: 1
 * Explanation: Only 1 platform is required to
 * safely manage the arrival and departure
 * of all trains.
 *
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function findPlatform() which takes the array arr[] (denoting the arrival times), array dep[] (denoting the departure times) and the size of the array as inputs and returns the minimum number of platforms required at the railway station such that no train waits.
 *
 * Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (between 00 to 59).
 *
 *
 *
 * Expected Time Complexity: O(nLogn)
 * Expected Auxiliary Space: O(n)
 *
 *
 *
 * Constraints:
 * 1 <= n <= 50000
 * 0000 <= A[i] < D[i] <= 2359
 */
public class MinimumPlatforms extends Algorithm {
    private Integer[] arrivals;
    private Integer[] departures;

    @Override
    protected void init() {
        //arrivals = new Integer[] {900, 940, 950, 1100, 1500, 1800};
        //departures = new Integer[] {910, 1200, 1120, 1130, 1900, 2000};
        arrivals = new Integer[]{900, 1100, 1235};
        departures = new Integer[]{1000, 1200, 1240};
    }

    @Override
    protected void run() {
        System.out.println(String.format("Minimum no. of platforms: %d", findPlatforms()));
    }

    private int findPlatforms() {
        Train[] trains = new Train[arrivals.length];

        // Initialize trains
        for(int i=0; i<arrivals.length; i++){
            trains[i] = new Train(arrivals[i], departures[i]);
        }

        // Sort train based on arrival
        Arrays.sort(trains);

        List<Integer> platforms = new ArrayList<>();
        for (int i=0; i<trains.length; i++){
            boolean trainAddedToPlatform = false;
            for (int j=0; j<platforms.size(); j++){
                if (platforms.get(j) < trains[i].arrivalTime) {
                    platforms.set(j, trains[i].departureTime);
                    trainAddedToPlatform = true;
                    break;
                }
            }

            if (!trainAddedToPlatform) {
                platforms.add(trains[i].departureTime);
            }
        }

        return platforms.size();
    }

    class Train implements Comparable<Train>{
        public int arrivalTime;
        public int departureTime;

        public Train(int a, int d){
            this.arrivalTime = a;
            this.departureTime = d;
        }

        @Override
        public int compareTo(Train o) {
            return Integer.compare(this.arrivalTime, o.arrivalTime);
        }
    }
}