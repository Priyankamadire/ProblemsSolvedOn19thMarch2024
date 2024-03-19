
/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= 
n), ans[i] is the number of 1's in the binary representation of i.
Input: n = 2
Output: [0,1,1] 
Explanation:
0 --> 0
1 --> 1
2 --> 10
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11 
4 --> 100  
5 --> 101

TESTCASES
---------------------

case=1
input=2
output=0
1
1

case=2
input=5
output=0
1
1
2
1
2
*/
import java.util.*;

public class CountingBits {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(Arrays.toString(solve(n)));
    }

    public static int[] solve(int n) {
        int res[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = help(i);
        }
        return res;
    }

    public static int help(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt;
    }
}