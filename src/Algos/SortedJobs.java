package Algos;

import models.Job;

import java.util.*;

public class SortedJobs {
    private HashMap<Integer, Job>  map;
    private TreeMap<Integer, Job> treeMap;

    public SortedJobs(){
        this.map = new HashMap<>();
        this.treeMap = new TreeMap<>();
    }

    public boolean add(int jobId, int value){
        if (this.map.containsKey(jobId)) {
            return false;
        }

        Job job = new Job(jobId, value);
        this.map.put(jobId, job);
        this.treeMap.put(value, job);
        return true;
    }

    public List<Job> all(int startValue){
        if (!this.treeMap.containsKey(startValue)) {
            return null;
        }

        List<Job> jobList = new ArrayList<>();
        this.treeMap.subMap(startValue, this.treeMap.lastKey() + 1).forEach((value, job) -> {
            jobList.add(job);
        });

        return jobList;
    }

    public boolean remove(int jobId){
        if (!this.map.containsKey(jobId)) {
            return false;
        }

        // Get Job by id
        Job job = this.map.get(jobId);

        // Remove Job
        this.treeMap.remove(job.value);
        this.map.remove(jobId);

        return true;
    }
}

