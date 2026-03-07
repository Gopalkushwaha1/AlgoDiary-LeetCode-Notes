/*
 ================================================================
 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha
 ---------------------------------------------------------------
 🧠 Problem: 1888. Minimum Number of Flips to Make the Binary String Alternating
 🔗 Platform: LeetCode
 🏷 Difficulty: Medium
 ---------------------------------------------------------------
 💡 Approach:
 Sliding Window + Alternating Pattern Matching

 We generate two alternating patterns:
 1️⃣ Starting with '0' → 010101...
 2️⃣ Starting with '1' → 101010...

 To simulate all rotations efficiently, we concatenate
 the string with itself (s + s) and apply a sliding window
 of size n while counting mismatches with both patterns.

 ---------------------------------------------------------------
 ⏱ Time Complexity : O(n)
 📦 Space Complexity: O(n)
 ---------------------------------------------------------------
 ✍️ Author: Gopal Kushwaha
 📚 Repository: AlgoDiary-LeetCode-Notes
 ================================================================
*/

class Solution {
    public int minFlips(String s) {
        int n = s.length(); 
        char[] onePattern = new char[2*n]; 
        char[] zeroPattern = new char[2*n];

        StringBuilder sb = new StringBuilder(s + s); 
        int zeroCount = 0; 
        int oneCount = 0; 
        int ans = Integer.MAX_VALUE; 

        // fill the pattern
        for (int i = 0; i < 2*n; i++) {
            if (i % 2 == 0) {
                zeroPattern[i] = '0'; 
                onePattern[i] = '1'; 
            } else {
                zeroPattern[i] = '1'; 
                onePattern[i] = '0'; 
            }
        } 

        int i = 0; 
        int j = 0; 

        while (i < n) {
            char ch = sb.charAt(i); 

            if (ch != zeroPattern[i]) {
                zeroCount++; 
            } else {
                oneCount++; 
            }
            i++; 
        }

        ans = Math.min(oneCount, zeroCount); 

        // sliding window
        while (i < 2*n) {
            char currChar = sb.charAt(i); 
            char prevChar = sb.charAt(j);

            if (currChar != zeroPattern[i]) {
                zeroCount++; 
            } else {
                oneCount++; 
            }

            if (prevChar != zeroPattern[j]) {
                zeroCount--; 
            } else {
                oneCount--; 
            }

            ans = Math.min(ans, Math.min(oneCount, zeroCount));

            i++; 
            j++;  
        }
        return ans; 
    }
}
