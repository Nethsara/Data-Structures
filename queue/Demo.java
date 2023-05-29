package queue;

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

interface Queue {
    public void enQueue(Object obj);

    public void deQueue();

    public Object peek();

    public Object poll();

    public Object[] toArray();

    public void clear();

    public int size();

    public boolean isEmpty();

    public int search(Object obj);
}

class QueueImpl implements Queue {
    private Object[] objectArray;
    private int nextIndex = 0;

    QueueImpl() {
        objectArray = new Object[100];
    }

    public void enQueue(Object obj) {
        objectArray[nextIndex++] = obj;
    }

    public void deQueue() {
        if (!isEmpty()) {
            for (int i = 0; i < nextIndex - 1; i++) {
                objectArray[i] = objectArray[i + 1];
            }
            nextIndex--;
        }
    }

    public String toString() {
        String list = "[";
        for (int i = 0; i < nextIndex; i++) {
            list += objectArray[i] + ", ";
        }
        return isEmpty() ? "[empty]" : list + "\b\b]";
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return objectArray[0];
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        Object obj = objectArray[0];
        deQueue();
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
        for (int i = 0; i < nextIndex; i++) {
            temp[i] = objectArray[i];
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
        Queue intQueue = new QueueImpl();
        intQueue.enQueue(100);
        intQueue.enQueue(200);
        intQueue.enQueue(300);
        intQueue.enQueue(400);
        intQueue.enQueue(500);
        System.out.println(intQueue);

        intQueue.deQueue();
        System.out.println(intQueue);
    }
}
