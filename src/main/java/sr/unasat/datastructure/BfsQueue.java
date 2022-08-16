package sr.unasat.datastructure;

import java.util.Arrays;

public class BfsQueue {

    private final int SIZE = 15;
    private QueObject[] queArray;
    private int front;
    private int rear;

    public BfsQueue() {
        queArray = new QueObject[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(QueObject item) {
        if ( rear == SIZE - 1 )
            rear = -1;
        queArray[++rear] = item;
    }

    public QueObject remove() {
        QueObject temp = queArray[front++];
        if ( front == SIZE )
            front = 0;
        return temp;
    }

    public boolean isEmpty() {
        return ((rear + 1 == front) || (front + SIZE - 1 == rear));
    }

    public void makeEmpty() {
        front = 0;
        rear = -1;
    }

    public void showQueue() {
        System.out.println(Arrays.toString(queArray));
    }

    //the following 2 methods are for testing purposes only
    public QueObject peekFront() {return queArray[front];}

    public QueObject peekRear() {return queArray[rear];}

}
