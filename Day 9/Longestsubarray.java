import java.util.*;
public class Main {
    public static int[] res(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int startIndex = -1;
        for (int start = 0; start < n; start++) {
            int ones = 0;
            int zeros = 0;
            for (int end = start; end < n; end++) {
               if (arr[end] == 1) ones++;
                else zeros++;
                if (ones == zeros + 1) {
                    int len = end - start + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        startIndex = start;
                    }
                }
            }
        }
        if (maxLen == 0) {
            return new int[0];
        }
        int[] result = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            result[i] = arr[startIndex + i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = res(arr);
        if (ans.length == 0) {
            System.out.println("[]");
        } else {
            for (int x : ans) {
                System.out.print(x + " ");
            }
        }
    }
}
