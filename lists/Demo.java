package lists;

interface List {

    public void add(Object obj); // add to the last

    public void add(int index, Object obj); // add to the last

    public void remove(int index);

    public void remove(Object obj);

    public Object get(int index);

    public int search(Object obj);

    public boolean contains(Object obj);

    public void clear();

    public int size();

    public Object[] toArray();

    public void remove(int startIndex, int endIndex);

    public boolean isEmpty();

}

class ListImpl implements List {
    private Object[] objectArray;
    private int nextIndex = 0;

    ListImpl() {
        objectArray = new Object[100];
    }

    @Override
    public void add(Object obj) {
        objectArray[nextIndex++] = obj;

    }

    @Override
    public void add(int index, Object obj) {
        if (index > nextIndex)
            return;
        Object[] temp = new Object[objectArray.length + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = objectArray[i];
        }
        temp[index] = obj;
        for (int i = index + 1; i < temp.length; i++) {
            temp[i] = objectArray[i - 1];
        }
        objectArray = temp;
        nextIndex++;
    }

    @Override
    public void remove(int index) {
        Object[] temp = new Object[objectArray.length];
        for (int i = 0; i < index; i++) {
            temp[i] = objectArray[i];
        }
        for (int i = index; i < objectArray.length - 1; i++) {
            temp[i] = objectArray[i + 1];
        }
        objectArray = temp;
        nextIndex--;
    }

    @Override
    public void remove(Object obj) {
        int index = search(obj);
        Object[] temp = new Object[objectArray.length];
        for (int i = 0; i < index; i++) {
            temp[i] = objectArray[i];
        }
        for (int i = index; i < objectArray.length - 1; i++) {
            temp[i] = objectArray[i + 1];
        }
        objectArray = temp;
        nextIndex--;
    }

    @Override
    public Object get(int index) {
        return objectArray[index];
    }

    @Override
    public int search(Object obj) {
        for (int i = 0; i < nextIndex; i++) {
            if (objectArray[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        for (Object object : objectArray) {
            if (object.equals(obj)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void clear() {
        nextIndex = 0;

    }

    @Override
    public int size() {
        return nextIndex;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[nextIndex];
        for (int i = 0; i < nextIndex; i++) {
            temp[i] = objectArray[i];
        }
        return temp;
    }

    @Override
    public void remove(int startIndex, int endIndex) {

        int removedCount = endIndex - startIndex + 1;
        Object[] temp = new Object[objectArray.length - removedCount];

        for (int i = 0; i < startIndex; i++) {
            temp[i] = objectArray[i];
        }

        for (int i = endIndex + 1; i < nextIndex; i++) {
            temp[i - removedCount] = objectArray[i];
        }

        objectArray = temp;
        nextIndex -= removedCount;
    }

    @Override
    public boolean isEmpty() {
        return nextIndex == 0;
    }

    public String toString() {
        String list = "[";
        for (int i = 0; i < nextIndex; i++) {
            list += objectArray[i] + ", ";
        }
        return isEmpty() ? "[empty]" : list + "\b\b]";
    }
}

class Demo {
    public static void main(String[] args) {
        List newL = new ListImpl();
        newL.add(10);
        newL.add(20);
        newL.add(30);
        newL.add(40);
        newL.add(50);
        newL.add(60);
        newL.add(70);
        newL.add(80);

        System.out.println(newL);

        newL.remove(1, 5);
        System.out.println(newL);

    }
}