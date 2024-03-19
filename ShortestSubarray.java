
/*Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K. If 
there is no non-empty subarray with sum at least K, return -1. 
Example 1: 
Input: A = [1], K = 1 
Output: 1 
Example 2: 
Input: A = [1,2], K = 4 
Output: -1 
Example 3: 
Input: A = [2,-1,2], K = 3 
Output: 3 
Note: 
1 <= A.length <= 50000 
-10 ^ 5 <= A[i] <= 10 ^ 5 
1 <= K <= 10 ^ 9


TESTCASES:
____________________________

case=1
input=1
1
1
output=1

case=2
input=2
4
1
2
output=-1

case=3
input=3
3
2
-1
2

output=3
*/
import java.util.*;

public class ShortestSubarray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(solve(n, arr, sum));
    }

    public static int solve(int n, int arr[], int sum) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE, su = 0;
        while (j < n) {
            su += arr[j];
            while (su >= sum) {
                ans = Math.min(ans, j - i + 1);
                su -= arr[i];
                i++;
            }
            j++;

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}