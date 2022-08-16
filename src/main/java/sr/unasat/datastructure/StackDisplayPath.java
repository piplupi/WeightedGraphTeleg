package sr.unasat.datastructure;

import sr.unasat.entity.Hubs;
import java.util.Arrays;

public class StackDisplayPath {
    private final int SIZE = 15;
    private Hubs[] hubsStack;
    private int top;


    public StackDisplayPath(){
        hubsStack = new Hubs[SIZE];
        top = -1;
    }

    public void push(Hubs hubStack) {
        hubsStack[++top] = hubStack;
    }

    public Hubs pop() {
        return hubsStack[top--];
    }

    public Hubs peek() {
        return hubsStack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void showStack() {
        System.out.println(Arrays.toString(hubsStack));
    }

}
