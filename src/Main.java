import Algos.*;
import models.Job;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        runAlgo();
        //runUC();
    }

    private static void runAlgo(){
        // new SubArrayWithGivenSum().initAndRun();
        // new ChocolateDistributionProblem().initAndRun();
        // new LeftViewOfBinaryTree().initAndRun();
        // new VerticalTraversalOfBinaryTree().initAndRun();
        // new MedianInStream().initAndRun();
        // new GraphAdjacencyList().initAndRun();
        // new LargestNumberFormedFromArray().initAndRun();
        // new MinimumOperationToReachN().initAndRun();
        new MaxLengthChain().initAndRun();
    }

    private static void runUC(){
        SortedJobs sortedJobs = new SortedJobs();

        sortedJobs.add(1, 5);
        sortedJobs.add(2, 10);
        sortedJobs.add(3, 15);
        sortedJobs.add(4, 20);
        sortedJobs.add(5, 25);
        sortedJobs.add(6, -1);
        sortedJobs.add(7, 11);
        sortedJobs.add(8, 21);

        printJobs(sortedJobs.all(5));
        printJobs(sortedJobs.all(-1));

        sortedJobs.remove(5);
        printJobs(sortedJobs.all(5));

        sortedJobs.remove(3);
        printJobs(sortedJobs.all(-1));
    }

    private static void printJobs(List<Job> jobs){
        if (jobs != null) {
            jobs.forEach(job -> System.out.print(job.id + ": " + job.value + ", "));
            System.out.println();
        }
    }
}
