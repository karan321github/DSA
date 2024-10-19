import java.util.*;

public class Strings {
  public static String reverseString(String str) {
    String ans = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      ans += str.charAt(i);
    }
    return ans;
  }

  public static boolean isPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;

    while (i <= j) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static String reverseWords(String str) {
    String reverse = "";
    String[] strArr = str.split(" ");
    for (int i = strArr.length - 1; i >= 0; i--) {
      reverse += strArr[i] + " ";
    }
    return reverse;
  }

  public static String rverseWordString(String str) {
    String ans = "";
    String strArr[] = str.split(" ");
    for (int i = strArr.length - 1; i >= 0; i--) {
      ans += reverseString(strArr[i]) + " ";
    }
    return ans;
  }

  public static void countOccurrences(String str) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < str.length(); i++) {
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    }
    for (char i : map.keySet()) {
      System.out.println(i + " - " + map.get(i));
    }
  }

  public static String removeDuplicate(String str) {
    StringBuilder ans = new StringBuilder();
    boolean arr[] = new boolean[26];
    for (char c : str.toCharArray()) {
      if (!arr[c - 'a']) {
        ans.append(c);
      }
      arr[c - 'a'] = true;
    }

    return ans.toString();
  }

  public static String removeDuplicate1(String str) {
    StringBuilder ans = new StringBuilder();
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char c : str.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c : map.keySet()) {
      ans.append(c);
    }
    return ans.toString();
  }

  public static String longestCommonPrefix(String[] strs) {
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
      if (prefix.length() == 0) {
        return "";
      }
    }
    return prefix;
  }

  public static void print2DArray(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(arr[i][j] + " ");

      }
      System.out.println();
    }
  }

  public static void merge(int nums1[], int nums2[], int m, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[k] = nums1[i];
        i--;

      } else {
        nums1[k] = nums2[j];
        j--;
      }
      k--;
    }

    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }
    for (int l = 0; l < nums1.length; l++) {
      System.out.print(nums1[l] + " ");
    }
  }

  public static String reverseWordInAString(String s) {
    StringBuilder ans = new StringBuilder();
    String strArr[] = s.split(" ");
    for (int i = strArr.length - 1; i >= 0; i--) {
      ans.append(strArr[i] + " ");
    }
    return ans.toString().trim();
  }

  public static int LengthOfTheLastWord(String s) {
    String arr[] = s.trim().split("\\s+");
    int n = arr.length;
    String ans = arr[n - 1].trim();
    return ans.length();

  }

  public static int LengthOfTheLastWord2(String s) {
    int count = 0;
    String str = s.trim();
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) != ' ') {
        count++;
      } else {
        break;
      }
    }

    return count;

  }

  public static void main(String[] args) {
    int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    print2DArray(arr);
    String str = "helloworld";
    String strs[] = { "flower", "flow", "flight" };
    System.out.println(reverseString(str));
    System.out.println(isPalindrome(str));
    System.out.println(reverseWords(str));
    System.out.println(rverseWordString(str));
    System.out.println();
    countOccurrences(str);
    System.out.println(removeDuplicate(str));
    System.out.println(removeDuplicate1(str));
    System.out.println(longestCommonPrefix(strs));
    int num1[] = { 1, 2, 3, 0, 0, 0 };
    int num2[] = { 2, 5, 6 };
    merge(num1, num2, 3, 3);
    System.out.println();
    String s = "The lazy dog jumps over the fox";
    System.out.println(LengthOfTheLastWord(s));
    System.out.println(reverseWordInAString(s));
  }
}