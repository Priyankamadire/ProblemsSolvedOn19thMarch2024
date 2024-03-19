/*1684. Count the Number of Consistent Strings
Solved
Easy
Topics
Companies
Hint
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
  */
  class ConsistentSTr {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt =0;
         for(String w:words){
            boolean flag = true;
            for(char c : w.toCharArray()){
                if(allowed.indexOf(c)==-1){
                    flag=false;
                    break;
                }
            }
            if(flag){
                cnt++;
            }
         }
        return cnt;
    }
}