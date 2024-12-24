package Recursion;

public class Recursion {
        public static void printInDecreasingOrder(int n) {
                if (n < 0) {
                        return;
                }
                System.out.print(n + " ");
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
                if (n == 1) {
                        System.out.print(n + " ");
                        return;
                }
                printInc(n - 1);
                System.out.print(n + " ");

        }

        public static int factorial(int n) {
                if (n == 1 || n == 0) {
                        return n;
                }
                int ans = n * factorial(n - 1);
                return ans;
        }

        public static int sumOfNNaturalNumbers(int n) {
                if (n == 1) {
                        return 1;
                }
                int s_n = sumOfNNaturalNumbers(n - 1);
                int sum = n + s_n;
                return sum;
        }

        public static int printNthFibNumber(int n) {
                if (n == 0 || n == 1) {
                        return n;
                }
                int n_1 = printNthFibNumber(n - 1);
                int n_2 = printNthFibNumber(n - 2);
                return n_1 + n_2;
        }

        public static boolean checkArraySortedOrNot(int arr[], int i) {

                if (i == arr.length - 1) {
                        return true;
                }
                if (arr[i] > arr[i + 1]) {
                        return false;
                }

                return checkArraySortedOrNot(arr, i + 1);
        }

        public static int firstOccurrences(int arr[], int target, int i) {
                if (arr[i] == target) {
                        return i;
                }
                int index = firstOccurrences(arr, target, i + 1);
                return index;
        }

        public static int lastOccurrence(int arr[], int target, int i) {
                if (i == arr.length) {
                        return -1;
                }
                int isFound = lastOccurrence(arr, target, i + 1);
                if (isFound == -1 && arr[i] == target) {
                        return i;
                }

                return isFound;
        }

        public static int tilingProblem(int n) {
                if (n == 0) {
                        return 1;
                }

                if (n == 1) {
                        return 1;
                }
                int ways = 0;
                ways = tilingProblem(n - 1); // When tile places vertical
                ways += tilingProblem(n - 2); // When tile places horizontal

                return ways;
        }

        public static String removeDuplicate(String str, StringBuilder ans, int i, boolean[] map) {
                if (i == str.length()) {
                        return ans.toString();
                }
                char c = str.charAt(i);
                if (!map[c - 'a']) {
                        map[c - 'a'] = true;
                        removeDuplicate(str, ans.append(c), i + 1, map);
                }
                return removeDuplicate(str, ans, i + 1, map);

        }

        public static int friendsPairing(int n) {
                if (n == 1 || n == 2) {
                        return n;
                }

                int totalNoOfWays = friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
                return totalNoOfWays;

        }

        public static void main(String[] args) {
                // printInDecreasingOrder(10);
                // System.out.println();
                // printNumbersInIncreasingOrder(10, 20);
                // System.out.println();
                // printInc(5);
                // System.out.println();
                // System.out.println(factorial(5));
                // System.out.println(printNthFibNumber(5));
                // int arr[] = { 1, 2, 3, 4, 4, 5, 12, 9 };
                // System.out.println(checkArraySortedOrNot(arr, 0));

                // System.out.println(firstOccurrences(arr, 4, 0));
                // System.out.println(lastOccurrence(arr, 4, 0));
                // System.out.println(tilingProblem(4));
                // System.out.println(removeDuplicate("aabbcda", new StringBuilder(""), 0, new
                // boolean[26]));
                System.out.println(friendsPairing(3));
        }
}
