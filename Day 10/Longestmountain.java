import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxLen = 0;
        int start = -1, end = -1;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;
                while ((left > 0 && arr[left] > arr[left - 1])&&(right < n - 1 && arr[right] > arr[right + 1])) {
                    left--;right++;
                }
                int length = right - left + 1;
                if (length > maxLen) {
                    maxLen = length;
                    start = left;
                    end = right;
                }
            }
        }
        if (maxLen >= 3) {
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("No mountain subarray");
        }
    }
}
