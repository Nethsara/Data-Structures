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
    private int nextIndex;
    private float loadFactor;

    Stack(int initialCapacity, float loadFactor) {
        dataArray = new int[initialCapacity];
        nextIndex = 0;
        this.loadFactor = loadFactor;
    }

    private void extendArray() {
        int newSize = dataArray.length + (int) (dataArray.length * loadFactor);
        int[] temp = new int[newSize];
    }

    public void push(int data) {
        if (nextIndex >= dataArray.length) {
            extendArray();
        }
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
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
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

    public int size() {
        return nextIndex;
    }

    public void clear() {
        nextIndex = 0;
    }

    public int[] toArray() {
        int[] temp = new int[nextIndex];
        for (int i = 0, j = nextIndex - 1; i < nextIndex; i++, j--) {
            temp[i] = dataArray[j];
        }
        return temp;
    }

    public boolean isEmpty() {
        return nextIndex <= 0;
    }
}

class Demo {
    public static void main(String args[]) {
        Stack s1 = new Stack(100, .5f);
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
