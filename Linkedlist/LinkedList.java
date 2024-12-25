package Linkedlist;

public class LinkedList {
        public static Node head;
        public static Node tail;

        class Node {
                int data;
                Node next;

                public Node(int data) {
                        this.data = data;
                        this.next = null;
                }
        }

        public void AddFirst(int data) {
                // Step first - create a node first
                Node newNode = new Node(data);
                if (head == null) {
                        head = tail = newNode;
                }

                // step-2
                newNode.next = head;
                head = newNode;
        }

        public void AddLast(int data) {
                Node newNode = new Node(data);
                if (head == null) {
                        head = tail = newNode;
                }

                tail.next = newNode;
                tail = newNode;
        }

        public static void printLL() {
                Node temp = head;
                while (temp != null) {
                        System.out.print(temp.data + " -> ");
                        temp = temp.next;
                }
                System.out.println("null");
        }

        public static void reverseLinkedList() {
                Node curr = head;
                Node prev = null;
                Node next = null;

                while (curr != null) {
                     next = curr.next;
                     curr.next = prev;
                     prev = curr;
                     curr = next;
                }
                head = prev;
        }
        
        
        public static void main(String[] args) {
                LinkedList ll = new LinkedList();
                ll.AddFirst(1);
                ll.AddFirst(2);
                ll.AddFirst(3);
                ll.AddLast(0);
                ll.AddLast(6);
                ll.printLL();
                ll.reverseLinkedList();
                ll.printLL();
        }
}
