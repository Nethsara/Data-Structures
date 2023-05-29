package stack;

interface StackInterface {
    public void push(int data);

    public void printStack();

    public void pop();

    public int peek();

    public int poll();

    public int[] toArray();

    public void clear();

    public boolean isEmpty();

}

class NoSuchElementException extends RuntimeException {
    NoSuchElementException(String message) {
        super(message);
    }
}

class Stack implements StackInterface {
    private int[] dataArray;

    Stack() {
        dataArray = new int[0];
    }

    private void extendArray() {
        int[] temp = new int[dataArray.length + 1];
        for (int i = 0; i < dataArray.length; i++) {
            temp[i + 1] = dataArray[i];
        }
        dataArray = temp;

    }

    public void push(int data) {
        extendArray();
        dataArray[0] = data;
    }

    public void pop() {
        if (!isEmpty()) {
            int[] temp = new int[dataArray.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = dataArray[i + 1];
            }
            dataArray = temp;
        }
    }

    public void printStack() {
        System.out.print("[");
        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i] + ", ");
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        }
        return dataArray[0];
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        }
        int topData = dataArray[0];
        pop();
        return topData;
    }

    public int size() {
        return dataArray.length;
    }

    public void clear() {
        dataArray = new int[0];
    }

    public int[] toArray() {
        int[] temp = new int[dataArray.length];
        for (int i = 0; i < dataArray.length; i++) {
            temp[i] = dataArray[i];
        }
        return temp;
    }

    public boolean isEmpty() {
        return dataArray.length == 0;
    }
}

class Demo {
    public static void main(String args[]) {
        Stack s1 = new Stack();
        s1.printStack(); // [empty]
        System.out.println("Size of the stack : " + s1.size());// 0
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);

        s1.printStack(); // [50,40,30,20,10]
        System.out.println("Size of the stack : " + s1.size());// 5

        s1.clear();
        s1.printStack(); // [empty]
        System.out.println("Size of the stack : " + s1.size());// 0

        s1.peek(); // throw an exception
    }
}
