
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CharNode {
    char data;
    CharNode next;

    CharNode(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;
    int count = 0;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        count++;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;
        count--;

        return value;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return count;
    }

    void display() {
        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Find middle element
    void middle() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        Node slow = top;
        Node fast = top;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle: " + slow.data);
    }

    // Reverse using another stack
    Stack reverse() {
        Stack temp = new Stack();

        Node current = top;

        while (current != null) {
            temp.push(current.data);
            current = current.next;
        }

        return temp;
    }
}

class CharStack {
    CharNode top;

    void push(char ch) {
        CharNode newNode = new CharNode(ch);
        newNode.next = top;
        top = newNode;
    }

    char pop() {
        char ch = top.data;
        top = top.next;
        return ch;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class Main {

    // Reverse a string
    static String reverseString(String str) {
        CharStack s = new CharStack();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        String result = "";

        while (!s.isEmpty()) {
            result += s.pop();
        }

        return result;
    }

    // Check palindrome
    static void palindrome(String str) {
        String reversed = reverseString(str);

        if (str.equalsIgnoreCase(reversed)) {
            System.out.println(str + " is Palindrome");
        } else {
            System.out.println(str + " is Not Palindrome");
        }
    }

    public static void main(String[] args) {

        Stack s = new Stack();

        // Basic stack operations
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        System.out.print("Original Stack: ");
        s.display();

        System.out.println("Top: " + s.peek());
        System.out.println("Size: " + s.size());

        s.middle();

        // Reverse stack
        Stack reversedStack = s.reverse();

        System.out.print("Reversed Stack: ");
        reversedStack.display();

        // String reversal
        String str = "HELLO";

        System.out.println("Original String: " + str);
        System.out.println("Reversed String: "
                + reverseString(str));

        // Palindrome checking
        palindrome("MADAM");
        palindrome("HELLO");
    }
}
