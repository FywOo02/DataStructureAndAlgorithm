package Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("The stack is full now");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("The stack is empty now");
        }
        int value = stack[top];
        top--;
        return value;

    }

    public void show(){
        if(isEmpty()){
            System.out.println("Stack is empty now");
            return;
        }
        for(int i=top; i>=0; i--){
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
