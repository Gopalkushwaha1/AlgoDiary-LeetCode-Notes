"""
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
"""

class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)

        one_pattern = [''] * (2 * n)
        zero_pattern = [''] * (2 * n)

        sb = s + s
        zero_count = 0
        one_count = 0
        ans = float('inf')

        # fill the pattern
        for i in range(2 * n):
            if i % 2 == 0:
                zero_pattern[i] = '0'
                one_pattern[i] = '1'
            else:
                zero_pattern[i] = '1'
                one_pattern[i] = '0'

        i = 0
        j = 0

        while i < n:
            ch = sb[i]

            if ch != zero_pattern[i]:
                zero_count += 1
            else:
                one_count += 1

            i += 1

        ans = min(one_count, zero_count)

        # sliding window
        while i < 2 * n:
            curr_char = sb[i]
            prev_char = sb[j]

            if curr_char != zero_pattern[i]:
                zero_count += 1
            else:
                one_count += 1

            if prev_char != zero_pattern[j]:
                zero_count -= 1
            else:
                one_count -= 1

            ans = min(ans, min(one_count, zero_count))

            i += 1
            j += 1

        return ans
