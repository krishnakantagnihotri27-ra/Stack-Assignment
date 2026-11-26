
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(char ch) {
        Node newNode = new Node(ch);
        newNode.next = top;
        top = newNode;
    }

    char pop() {
        if (top == null) {
            return '\0';
        }

        char value = top.data;
        top = top.next;
        return value;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {

        Stack s = new Stack();

        String str = "MADAM";

        // Insert characters into stack
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        String reversed = "";

        // Remove characters from stack
        while (!s.isEmpty()) {
            reversed += s.pop();
        }

        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);

        if (str.equalsIgnoreCase(reversed)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is Not Palindrome");
        }
    }
}
