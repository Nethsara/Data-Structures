package stack;

interface StackInterface {
    public void push(int data);

    public void printStack();

    public void pop();

    public int peek();

    public int poll();
    /* public int[] toArray(); */

}

class NoSuchElementException extends RuntimeException {
    NoSuchElementException(String message) {
        super(message);
    }
}

class Stack implements StackInterface {
    private int[] dataArray;
    private int nextIndex;

    Stack() {
        dataArray = new int[100];
        nextIndex = 0;
    }

    public void push(int data) {
        dataArray[nextIndex++] = data;
    }

    public void pop() {
        if (nextIndex > 0) {
            nextIndex--;
        }
    }

    public void printStack() {
        System.out.print("[");
        for (int i = nextIndex - 1; i >= 0; i--) {
            System.out.print(dataArray[i] + ", ");
        }
        System.out.println("\b\b]");
    }

    public int peek() {
        if (nextIndex <= 0) {
            throw new NoSuchElementException("Empty Stack");
        }
        return dataArray[nextIndex - 1];
    }

    public int poll() {
        if (nextIndex <= 0) {
            throw new NoSuchElementException("Empty Stack");
        }
        return dataArray[--nextIndex];
    }

    /*
     * public int[] toArray();
     * 
     */
}

class Demo {
    public static void main(String args[]) {
        Stack s1 = new Stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        s1.printStack(); // [50,40,30,20,10]
        System.out.println();

        int topData = s1.peek();
        System.out.println("Top data : " + topData); // 50
        s1.printStack(); // [50,40,30,20,10]
        System.out.println();

        topData = s1.poll();
        System.out.println("Top data : " + topData); // 50
        s1.printStack(); // [40,30,20,10]
    }
}
