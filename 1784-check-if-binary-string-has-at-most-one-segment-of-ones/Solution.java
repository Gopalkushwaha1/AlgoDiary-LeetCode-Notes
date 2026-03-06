/*
 ============================================================
 🚀 Welcome to AlgoDiary - Gopal Kushwaha
 ------------------------------------------------------------
 Think • Learn • Optimize
 ------------------------------------------------------------
 Problem: 1784. Check if Binary String Has at Most One Segment of Ones
 ------------------------------------------------------------
 Time Complexity: O(n)
 Space Complexity: O(1)
 ============================================================
*/

class Solution {

    public boolean checkOnesSegment(String s) {

        int i = 0;

        // move through the first segment of '1'
        while (i < s.length() && s.charAt(i) == '1') {
            i++;
        }

        // if '1' appears again later -> more than one segment
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                return false;
            }
        }

        return true;
    }
}
