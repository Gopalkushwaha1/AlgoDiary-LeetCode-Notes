"""
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
"""

class Solution:
    def checkOnesSegment(self, s: str) -> bool:

        i = 0

        # move through the first segment of '1'
        while i < len(s) and s[i] == '1':
            i += 1

        # if '1' appears again later -> more than one segment
        for j in range(i, len(s)):
            if s[j] == '1':
                return False

        return True
