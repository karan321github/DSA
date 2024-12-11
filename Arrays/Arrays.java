package Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Arrays {

        public void minAndMaxInAnArray(int arr[]) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < arr.length; i++) {
                        if (arr[i] < min) {
                                min = arr[i];
                        } else if (arr[i] > max) {
                                max = arr[i];
                        }
                }
                System.out.println("min_value " + min);
                System.out.println("max_value " + max);
        }

        public boolean compareToString(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1) > 0;
        }

        public String FindLargest(int arr[]) {
                ArrayList<String> list = new ArrayList<>();
                for (int i : arr) {
                        list.add(Integer.toString(i));
                }
                Collections.sort(list, (s1, s2) -> compareToString(s1, s2) ? -1 : 1);
                if (list.get(0).equals("0")) {
                        return "0";
                }

                StringBuilder ans = new StringBuilder();
                for (String s : list) {
                        ans.append(s);
                }

                return ans.toString();
        }

        public void main(String[] args) {
                int arr[] = { 1, 10, 2, 9, 7, 8, 20, 4, 5 };
                minAndMaxInAnArray(arr);
        }
}
