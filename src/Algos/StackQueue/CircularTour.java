package Algos.StackQueue;

import models.Algorithm;

public class CircularTour extends Algorithm {
    @Override
    protected void init() {
    }

    @Override
    protected void run() {
        int[] input = new int[] {98, 18, 82, 72, 10, 76, 68, 28, 98, 57, 87, 54, 7, 66, 20, 84, 29, 25, 33, 72, 4, 30, 71, 20, 9, 69, 41, 16, 97, 50, 19, 24, 47, 46, 22, 52, 80, 56, 65, 89, 42, 29, 94, 51, 35, 1, 25, 65, 88, 15, 44, 57, 28, 92, 60, 66, 33, 37, 38, 52, 76, 29, 75, 8};
        int[] petrol = new int[32];
        int[] distance = new int[32];

        for (int i=0, j=0, k=0; i < 64; i++) {
            if (i%2 == 0) {
                petrol[j++] = input[i];
            } else {
                distance[k++] = input[i];
            }
        }

        System.out.println(tour(petrol, distance));
    }


    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    // Assumption: Array at least has 1 element
    private int tour(int petrol[], int distance[]) {
        int sum = 0;
        for (int i=0; i< petrol.length; i++){
            petrol[i] = petrol[i] - distance[i];

            sum += petrol[i];
        }

        if (sum < 0)
            return -1;

        sum = 0;
        int front = 0; // Front is always 1 step ahead. meaning points to index where new element will be added
        int rear = -1; // Rear point to 1st element in queue
        while (!isFull(front, rear, petrol.length)) { // remember to reset if empty
            // Enqueue
            sum += petrol[front % petrol.length];
            if (rear < 0) // Set rear if empty
                rear = front;

            front++;

            // Deque while sum is negative
            while (sum < 0) {
                // Dequeue
                sum -= petrol[rear % petrol.length];
                rear++;

                // Check for empty queue. Sum will become zero when empty
                if (isFull(front, rear, petrol.length)) // Reset rear
                    rear = -1;
            }
        }

        return rear;
    }

    private boolean isFull(int front, int rear, int length) {
        return front % length == rear % length;
    }
}

class ArrQueue{
    char[] queue;
    int front;
    int rear;

    public ArrQueue(char[] q) {
        queue = q;
        front = 0; // Front is always 1 step ahead. meaning points to index where new element will be added
        rear = -1; // Rear point to 1st element in queue
    }

    public void insert(char item){
        if (isFull())
            return;

        queue[front%queue.length] = item;
        front++;

        if (rear < 0) // Initialize for empty queue
            rear++;
    }

    public int remove(){
        // Check for empty queue
        if (rear < 0) {
            // Queue is empty
            return -1;
        }

        int temp = queue[rear%queue.length];
        rear++;

        if (isFull()) { // Rear reached front while removing item. Means queue is empty. Reset
            rear = -1;
            front = 0;
        }

        return temp;
    }

    public boolean isFull() {
        return front% queue.length == rear%queue.length;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public char peek() {
        return queue[rear % queue.length];
    }
}
