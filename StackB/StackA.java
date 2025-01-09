package StackB;

import java.util.ArrayList;

public class StackA {

        static class Node {
                int data;
                Node next;

                public Node(int data) {
                        this.data = data;
                        this.next = null;
                }
        }

        static class Stack {
                static Node head;

                public static boolean isEmpty() {
                        return head == null;
                }

                public static void push(int data) {
                        Node newNode = new Node(data);
                        if (isEmpty()) {
                                head = newNode;
                                return;
                        }

                        newNode.next = head;
                        head = newNode;
                }

                public static int pop() {
                        if (isEmpty()) {
                                return -1;
                        }
                        int top = head.data;
                        head = head.next;
                        return top;
                }

                public static int peek() {
                        if (isEmpty()) {
                                return -1;
                        }

                        return head.data;
                }
        }

        // static class Stack {
        // ArrayList<Integer> list = new ArrayList<>();

        // public boolean isEmpty() {
        // return list.size() == 0;

        // }

        // public void push(int data) {
        // list.add(data);
        // }

        // public int pop() {
        // if (isEmpty()) {
        // return -1;
        // }
        // int top = list.get(list.size() - 1);
        // list.remove(list.size() - 1);
        // return top;

        // }

        // public int peek() {
        // if (isEmpty()) {
        // return -1;
        // }
        // return list.get(list.size() - 1);
        // }
        // }

        public static void main(String[] args) {

                Stack s = new Stack();
                s.push(1);
                s.push(2);
                s.push(3);

                while (!s.isEmpty()) {
                        System.out.print(s.pop() + " ");
                }
        }

}
