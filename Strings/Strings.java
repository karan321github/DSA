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

  public static void main(String[] args) {
    String str = "helloworld";

    System.out.println(reverseString(str));
    System.out.println(isPalindrome(str));
    System.out.println(reverseWords(str));
    System.out.println(rverseWordString(str));
    System.out.println();
    countOccurrences(str);
    System.out.println(removeDuplicate(str));
    System.out.println(removeDuplicate1(str));
  }
}