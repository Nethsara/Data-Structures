package stack;

class Customer {
    private int code;
    private String name;

    Customer(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return code + "-" + name;
    }

    public boolean equals(Object obj) {
        return obj instanceof Customer ? ((Customer) obj).code == this.code : false;
    }
}

interface Stack {
    public void push(Object obj);

    public void pop();

    public Object peek();

    public Object poll();

    public Object[] toArray();

    public void clear();

    public int size();

    public boolean isEmpty();

    public int search(Object obj);
}

class StackImpl implements Stack {
    private Object[] objectArray;
    private int nextIndex = 0;

    StackImpl() {
        objectArray = new Object[100];
    }

    public void push(Object obj) {
        objectArray[nextIndex++] = obj;
    }

    public void pop() {
        if (!isEmpty()) {
            objectArray[--nextIndex] = null;
        }
    }

    public String toString() {
        String list = "[";
        for (int i = nextIndex - 1; i >= 0; i--) {
            list += objectArray[i] + ", ";
        }
        return isEmpty() ? "[empty]" : list + "\b\b]";
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return objectArray[nextIndex - 1];
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        Object obj = objectArray[nextIndex - 1];
        pop();
        return obj;
    }

    public int size() {
        return nextIndex;
    }

    public void clear() {
        nextIndex = 0;
    }

    public Object[] toArray() {
        Object[] temp = new Object[nextIndex];
        for (int i = 0, j = nextIndex - 1; i < nextIndex; i++, j--) {
            temp[i] = objectArray[j];
        }
        return temp;
    }

    public boolean isEmpty() {
        return nextIndex == 0;
    }

    public int search(Object obj) {
        for (int i = 0; i < nextIndex; i++) {
            if (objectArray[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }
}

class Demo {
    public static void main(String args[]) {
        Stack intStack = new StackImpl();
        intStack.push(100); // autobox, 100-->new Integer(100)
        intStack.push(200);
        intStack.push(300);
        intStack.push(400);
        intStack.push(500);
        System.out.println(intStack);

        Stack strStack = new StackImpl();
        strStack.push("Danapala");
        strStack.push("Gunapala");
        strStack.push("Somapala");
        strStack.push("Siripala");
        strStack.push("Amarapala");
        System.out.println(strStack);

        Stack custStack = new StackImpl();
        custStack.push(new Customer(1001, "Nimal"));
        custStack.push(new Customer(1002, "Bimal"));
        custStack.push(new Customer(1003, "Ranil"));
        System.out.println(custStack);
    }
}
