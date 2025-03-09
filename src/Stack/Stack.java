package Stack;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node (int val) {
            this.value = val;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }



    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }


    public void getHeight() {
        System.out.println("height: " +height);
    }




}
