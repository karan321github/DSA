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

  public static boolean isVowel(char c) {
    c = Character.toLowerCase(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public static String withoutVowels(String str) {
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (!isVowel(ch)) {
        ans.append(ch);
      }
    }
    return ans.toString();
  }

  public static String reverseWordsWithoutVowels(String str) {
    StringBuilder ans = new StringBuilder();
    String[] s = str.split(" ");
    for (int i = 0; i < s.length; i++) {
      String reversedString = reverseString(s[i]);
      String removeVowels = withoutVowels(reversedString);
      ans.append(removeVowels).append(" ");

    }
    return ans.toString();

  }

  // [1,0,2,0,3,0,4,0,5,0]; ["" , "" , "" ,"" , "" , "" , "" , "" , "" , ""]
  public static void zerosInEnd(int[] arr) {
    int j = 0, k = arr.length - 1;
    int newArr[] = new int[arr.length];
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] != 0) {
        newArr[j] = arr[i];
        j++;
      } else {

        newArr[k] = arr[i];
        k--;
      }

    }
    for (int i = 0; i < newArr.length; i++) {
      System.out.print(newArr[i] + " ");
    }
    System.out.println();
  }

  // nums = [-2,1,-3,4,-1,2,1,-5,4]
  public static int maxSubArraySum(int arr[]) {
    int max = Integer.MIN_VALUE;
    int currSum = 0;
    for (int i = 0; i < arr.length; i++) {
      currSum = Math.max(currSum += arr[i], arr[i]);
      max = Math.max(max, currSum);
    }
    return max;
  }

  public static boolean isDuplicate(int arr[]) {
    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      if (set.contains(i)) {
        return true;
      }
      set.add(i);
    }
    return false;

  }

  public static int searchInRotatedArray(int arr[], int target, int si, int ei) {
    int mid = (si + ei) / 2;
    if (arr[mid] == target) {
      return mid;
    }
    if (arr[si] <= arr[mid]) {
      // case a
      if (arr[si] <= target && target <= arr[mid]) {
        return searchInRotatedArray(arr, target, 0, mid - 1);
      } else {
        return searchInRotatedArray(arr, target, mid + 1, ei);
      }
    } else {
      if (arr[mid] <= target && target <= arr[ei]) {
        return searchInRotatedArray(arr, target, mid + 1, ei);
      } else {
        return searchInRotatedArray(arr, target, si, mid - 1);
      }
    }

  }

  // s = "A man, a plan, a canal: Panama"
  public static boolean validPalindrome(String str) {
    String s = str.trim().toLowerCase();
    int i = 0, j = s.length() - 1;
    while (i <= j) {
      if (!Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      } else if (!Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      } else {

        if (s.charAt(i) != s.charAt(j)) {
          return false;
        }
        i++;
        j--;
      }
    }
    return true;
  }

  public static boolean validAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c : t.toCharArray()) {
      if (map.get(c) != null) {
        if (map.get(c) == 1) {
          map.remove(c);
        } else {

          map.put(c, map.getOrDefault(c, 0) - 1);
        }
      } else {
        return false;
      }

    }

    return map.isEmpty();

  }

  public static void main(String[] args) {
    String s = "anagram", t = "nagaram";
    System.out.println(validAnagram(s, t));
    String str = "Naman";
    System.out.println(validPalindrome(str));
    System.out.println(reverseWordsWithoutVowels(str));
    System.out.println(withoutVowels(str));
    int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
    System.out.println(searchInRotatedArray(arr, 4, 0, arr.length - 1));
    System.out.println(maxSubArraySum(arr));
    System.out.println(isDuplicate(arr));
    zerosInEnd(arr);
    // int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // print2DArray(arr);
    // // String str = "helloworld";
    // String strs[] = { "flower", "flow", "flight" };
    // System.out.println(reverseString(str));
    // System.out.println(isPalindrome(str));
    // System.out.println(reverseWords(str));
    // System.out.println(rverseWordString(str));
    // System.out.println();
    // countOccurrences(str);
    // System.out.println(removeDuplicate(str));
    // System.out.println(removeDuplicate1(str));
    // System.out.println(longestCommonPrefix(strs));
    // int num1[] = { 1, 2, 3, 0, 0, 0 };
    // int num2[] = { 2, 5, 6 };
    // merge(num1, num2, 3, 3);
    // System.out.println();
    // String s = "The lazy dog jumps over the fox";
    // System.out.println(LengthOfTheLastWord(s));
    // System.out.println(reverseWordInAString(s));
  }
}