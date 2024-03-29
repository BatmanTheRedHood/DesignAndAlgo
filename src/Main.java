import Adhoc.Microsoft;
import Adhoc.Microsoft2;
import Algos.*;
import Algos.Arrays.BinarySearch;
import Algos.Arrays.NumberOfPairs;
import Algos.Arrays.NutsAndBolts;
import Algos.BackTracking.GenerateIPAddress;
import Algos.Recursion.CombinationSum;
import Algos.Recursion.FloodFillAlgorithm;
import Algos.Recursion.JosephusProblem;
import Algos.Recursion.SpecialKeyboard;
import Algos.StackQueue.*;
import Algos.Strings.*;
import Algos.Tree.MaximumPathSumBetween2LeafNodes;
import Design.LRUCache.LRUCache;
import models.Job;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args){
        // System.out.println("Hello World!");
        runAlgo();
        // testBinarySearch();
        // runUC();
        // runLRUCache();
    }








    private static void testBinarySearch(){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};

        /*
        * new Comparator<Integer>() {
        *    @Override
        *    public int compare(Integer o1, Integer o2) {
        *        return Integer.compare(o1, o2);
        *    }
        * }
        *
        * Can be replaced by lambda
        * (o1, o2) -> Integer.compare(o1, o2)
        *
        * Can be replaced by Integer method reference
        * Integer::compare
        */

        int key = 14;
        int result = BinarySearch.search(arr, key, 0, arr.length -1, Integer::compare);
        System.out.println(String.format("Search item %d is found at index %d", key, result));
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
        // new MaxLengthChain().initAndRun();
        // new SubstringsWithUniqueCharacter().initAndRun();
        // new CountTheTriplet().initAndRun();
        // new ContiguousSubArrayWithMaxSum().initAndRun();
        // new MergeWithoutExtraSpace().initAndRun();
        // new RearrangeArrayAlternatively().initAndRun();
        ////new NumberOfPairs().initAndRun();
        // new EquilibriumPoint().initAndRun();
        // new MinimumPlatforms().initAndRun();
        // new ReverseArrayInGroups().initAndRun();
        // new KthSmallestElement().initAndRun();
        // new TrappingRainWater().initAndRun();
        // new PythagoreanTriplet().initAndRun();
        // new StockBuyAndSell().initAndRun();
        // new PartitionElement().initAndRun();
        // new ArrayIntoZigZag().initAndRun();

        // String start
        // new ReverseWordInAString().initAndRun();
        // new PermutationsOfAString().initAndRun();
        // new LongestPalindromeInAString().initAndRun();
        //new RecursivelyRemoveAllAdjacentDuplicates().initAndRun();
        // new StringRotatedBy2Place().initAndRun();
        // new RomanNumberToInteger().initAndRun();
        // new Anagram().initAndRun();
        ////new FormAPalindrome().initAndRun();
        // new LongestDistinctCharactersInString().initAndRun();
        // new StringToInteger().initAndRun();
        // new FindSubstringInString().initAndRun();
        // new ParenthesisChecker().initAndRun();
        //new NextGreaterElement().initAndRun();
        ////new GetMinimumElementFromStack().initAndRun();
        // new CircularTour().initAndRun();
        // new FirstNonRepeatingCharacterInStream().initAndRun();
        // new MaximumOfAllSubarraysOfGivenSize().initAndRun();
        // new MaximumPathSumBetween2LeafNodes().initAndRun();
        /////new CombinationSum().notWorking();
        // new SpecialKeyboard().rum();
        ////new JosephusProblem().notWorking();
        // new Base10ToBase62().initAndRun();
        ////new SmallestWindowContainingString().initAndRun();
        // new NutsAndBolts().initAndRun();
        // new GenerateIPAddress().initAndRun();

        new Microsoft2().printHello();
    }

    private static void runLRUCache(){
        LRUCache cache = new LRUCache(5);

        // Let us refer pages 1, 2, 3, 1, 4, 5, 6, 7
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.printCache();

        cache.refer(1);
        cache.printCache();

        cache.refer(4);
        cache.refer(5);
        cache.printCache();

        cache.refer(6);
        cache.printCache();

        cache.refer(7);
        cache.printCache();

        cache.refer(7);
        cache.printCache();

        cache.refer(1);
        cache.printCache();

        cache.refer(2);
        cache.printCache();
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
