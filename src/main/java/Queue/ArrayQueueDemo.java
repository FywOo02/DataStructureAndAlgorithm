package Queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s: show queue");
            System.out.println("e: exit queue");
            System.out.println("a: add data to queue");
            System.out.println("g: get queue");
            System.out.println("h: get head of queue");
        }
    }
}

class ArrayQueue{
    private int maxSize; // the max size of array
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // indicate to head of queue
        rear = -1; // indicate the end of queue
    }

    // determine if the queue is full
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    // determine if the queue is empty
    public boolean isEmpty(){
        return rear == front;
    }

    // add the data to queue
    public void addQueue(int n){
        if (isFull()){
            System.out.println("The queue is full now");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //pop up the data
    public int popQueue(int n){
        if(isEmpty()){
            throw new RuntimeException("queue is empty now");
        }
        front++;
        return arr[front];
    }

    //show all data of queue
    public void showQueue(){
        if (isEmpty()){
            System.out.println("queue is empty now");
        }
        for(int i=0; i<arr.length; i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //show the front data
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty now");
        }
        return arr[front+1];
    }

}
