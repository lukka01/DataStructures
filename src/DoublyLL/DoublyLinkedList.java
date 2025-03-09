package DoublyLL;

import LeetCodeLists.LinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    class Node {
        int value;
        Node next;
        Node prev;
        Node (int val) {
            this.value = val;
        }
    }

    DoublyLinkedList(int val) {
        Node newNode = new Node(val);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }


    public void append(int val){
        Node newNode = new Node(val);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length --;
        return temp;
    }


    public Node get(int index) {
        if (index >= length || index < 0) return null;
        Node temp = head;
        if (index < length/2 ) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            for (int i = length-1; i > index ; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }






//    public Node get(int index) {
//        if (index >= length || index < 0) return null;
//        Node temp = head;
//        if (index < length/2) {
//            for (int i = 0; i < index; i++) {
//                temp = temp.next;
//            }
//        } else {
//            temp = tail;
//            for (int i = length-1; i < index; i--) {
//                temp = temp.prev;
//            }
//        }
//        return temp;
//    }




    public boolean set(int index, int val) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = val;
            return true;
        }
        return false;
    }





    public boolean insert(int index, int value) {
        if (index > length || index < 0) return false;
        if (index == 1) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;
        newNode.prev = before;
        before.next = newNode;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }


    public Node remove(int index) {
        if (index >= length || index < 0) return null;
        if (index == 0) return removeFirst();
        if (index == length-1) return removeLast();

        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }





}
