package stack;

class Customer {
    private int code;
    private String name;

    Customer(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCustomerDetails() {
        return code + "-" + name;
    }

    public boolean equals(Customer customer) {
        return this.code == customer.code;
    }
}

interface CustomerStack {
    public void push(Customer customer);

    public void printStack();

    public void pop();

    public Customer peek();

    public Customer poll();

    public Customer[] toArray();

    public void clear();

    public int size();

    public boolean isEmpty();

    public int search(Customer customer);
}

class CustomerStackImpl implements CustomerStack {
    private Customer[] customerArray;
    private int nextIndex = 0;

    CustomerStackImpl() {
        customerArray = new Customer[100];
    }

    public void push(Customer customer) {
        customerArray[nextIndex++] = customer;
    }

    public void pop() {
        if (!isEmpty()) {
            customerArray[--nextIndex] = null;
        }
    }

    public void printStack() {
        System.out.print("[");
        for (int i = nextIndex - 1; i >= 0; i--) {
            System.out.print(customerArray[i].getCustomerDetails() + ", ");
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    public Customer peek() {
        if (isEmpty()) {
            return null;
        }
        return customerArray[nextIndex - 1];
    }

    public Customer poll() {
        if (isEmpty()) {
            return null;
        }
        Customer customer = customerArray[nextIndex - 1];
        pop();
        return customer;
    }

    public int size() {
        return nextIndex;
    }

    public void clear() {
        nextIndex = 0;
    }

    public Customer[] toArray() {
        Customer[] temp = new Customer[nextIndex];
        for (int i = 0, j = nextIndex - 1; i < nextIndex; i++, j--) {
            temp[i] = customerArray[j];
        }
        return temp;
    }

    public boolean isEmpty() {
        return nextIndex == 0;
    }

    public int search(Customer customer) {
        for (int i = 0; i < nextIndex; i++) {
            if (customerArray[i].equals(customer)) {
                return i;
            }
        }
        return -1;
    }
}

class Demo {
    public static void main(String args[]) {
        CustomerStack custStack = new CustomerStackImpl();
        System.out.println("Size of the stack : " + custStack.size());
        custStack.printStack();
        System.out.println();

        custStack.push(new Customer(1001, "Danapala"));
        custStack.push(new Customer(1002, "Gunapala"));
        custStack.push(new Customer(1003, "Somapala"));
        custStack.push(new Customer(1004, "Siripala"));
        custStack.push(new Customer(1005, "Amarapala"));
        custStack.printStack();
        System.out.println("Size of the stack : " + custStack.size()); // 5
        System.out.println();

        custStack.pop();
        custStack.printStack();
        System.out.println("Size of the stack : " + custStack.size()); // 5
        System.out.println();

        Customer topCustomer = custStack.peek();
        System.out.println("Top Customer : " + topCustomer.getCustomerDetails());
        custStack.printStack();

        System.out.println();
        topCustomer = custStack.poll();
        System.out.println("Top Customer : " + topCustomer.getCustomerDetails());
        custStack.printStack();

        System.out.println();

        System.out.println("Index of 1002-Gunapala : " + custStack.search(new Customer(1002, "Gunapala")));
    }
}
