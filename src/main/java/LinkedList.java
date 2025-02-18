class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Append: Adds a new node to the end
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Prepend: Adds a new node to the beginning
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Returns the total number of nodes
    public int size() {
        return size;
    }

    // Returns the first node value
    public Integer getHead() {
        return (head != null) ? head.value : null;
    }

    // Returns the last node value
    public Integer getTail() {
        return (tail != null) ? tail.value : null;
    }

    // Returns the node value at a given index
    public Integer at(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    // Removes the last element
    public Integer pop() {
        if (head == null) return null;
        if (head == tail) {
            int value = head.value;
            head = tail = null;
            size--;
            return value;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        int value = tail.value;
        tail = current;
        tail.next = null;
        size--;
        return value;
    }

    // Checks if the value is in the list
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    // Finds the index of a node containing value
    public Integer find(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return null;
    }

    // Displays the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main function to test the linked list
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);
        list.display();

        System.out.println("Size: " + list.size());
        System.out.println("Head: " + list.getHead());
        System.out.println("Tail: " + list.getTail());
        System.out.println("At index 2: " + list.at(2));
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Index of 30: " + list.find(30));
        System.out.println("Popped: " + list.pop());
        list.display();
    }
}