
/*
You are starving and you want to eat food as quickly as possible. 
You want to find the shortest path to arrive at any food cell.
You are given an m x n character matrix, grid , of these different types of cells:
'' is your location. There is exactly one '' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south,
 or west of your current location if there is not an obstacle.
Return the length of the shortest path for you to reach any food cell. 
If there is no path for you to reach food,
 return -1 .


Note: The first line of the input contains the size of array followed by array elements.

Example=1

input=4 6
X X X X X X
X * O O O X
X O O # O X
X X X X X X
output=3
Explanation: It takes 3 steps to reach the food.

Example=2

input =4 5
X X X X X
X * X O X
X O X # X
X X X X X
output =-1
Explanation: It is not possible to reach the food.

Example=3

input =6 8
X X X X X X # O
X O O O O O X O
X O * O O O X O
X O O O O O O O 
O O O O X X X O
O O X X # O O O
output =10 */
import java.util.*;

public class ReachFood {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char mat[][] = new char[n][m];
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.next().charAt(0);
                if (mat[i][j] == '*') {
                    startX = i;
                    startY = j;
                }
            }
        }
        System.out.print(solve(mat, n, m, startX, startY));
    }

    public static boolean isSafe(char mat[][], int n, int m, int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m && mat[i][j] != 'X';
    }

    public static int solve(char mat[][], int n, int m, int i, int j) {
        if (!isSafe(mat, n, m, i, j)) {
            return -1;
        }
        if (mat[i][j] == '#') {
            return 0;
        }
        mat[i][j] = 'X';
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int minSteps = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            int steps = solve(mat, n, m, ni, nj);
            if (steps >= 0) {
                minSteps = Math.min(minSteps, steps + 1);
            }
        }
        mat[i][j] = 'O';
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}
