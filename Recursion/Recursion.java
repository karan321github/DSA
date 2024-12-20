package Recursion;

public class Recursion {
        public static void printInDecreasingOrder(int n) {
                if (n < 0) {
                        return;
                }
                System.out.print(n+" ");
                printInDecreasingOrder(n - 1);

        }

        public static void printNumbersInIncreasingOrder(int n, int target) {
                if (n == target) {
                        System.out.print(n + " ");
                        return;
                }
                System.out.print(n + " ");
                printNumbersInIncreasingOrder(n + 1, target);
        }

        public static void printInc(int n) {
          if(n == 1){
                System.out.print(n +" ");
                return;
          }      
          printInc(n-1);
          System.out.print(n +" ");
          
        }

        public static void main(String[] args) {
                printInDecreasingOrder(10);
                System.out.println();
                printNumbersInIncreasingOrder(10, 20);
                System.out.println();
                printInc(5);
        }
}
