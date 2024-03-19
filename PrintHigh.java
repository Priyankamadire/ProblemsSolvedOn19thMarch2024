
/*
Kalpana a third class student is playing with numbers. 
She has given her brother the same set of numbers and asked him to find the 
next greatest nearest number which contains the same set of digits same number of times. 

If no such number exists print -1 

input = 121
output = 211

input = 653
output = -1


input = 456
output = 465

 */
import java.util.*;

public class PrintHigh {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(solve(n));
    }

    public static int solve(int num) {

        char[] digits = Integer.toString(num).toCharArray();

        int pivotIndex = -1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                pivotIndex = i;
                break;
            }
        }

        if (pivotIndex == -1)
            return -1;

        int replacementIndex = pivotIndex + 1;
        for (int i = pivotIndex + 2; i < digits.length; i++) {
            if (digits[i] > digits[pivotIndex] && digits[i] < digits[replacementIndex]) {
                replacementIndex = i;
            }
        }

        char temp = digits[pivotIndex];
        digits[pivotIndex] = digits[replacementIndex];
        digits[replacementIndex] = temp;

        Arrays.sort(digits, pivotIndex + 1, digits.length);

        return Integer.parseInt(new String(digits));
    }

    public static void findper(String s, StringBuilder sb, List<String> al) {
        if (s.length() == sb.length()) {
            al.add(sb.toString());
            return;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (sb.indexOf(String.valueOf(s.charAt(i))) != -1) {
                continue;
            }
            sb.append(s.charAt(i));
            findper(s, sb, al);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> help(String s) {
        List<String> ls = new ArrayList<>();
        findper(s, new StringBuilder(), ls);
        return ls;
    }

}