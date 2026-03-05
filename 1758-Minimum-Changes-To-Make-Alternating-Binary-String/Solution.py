"""
 ============================================================
 🚀 AlgoDiary - by Gopal Kushwaha
 ------------------------------------------------------------
 Think • Learn • Optimize
 ------------------------------------------------------------
 Problem: 1758. Minimum Changes To Make Alternating Binary String
 Approach: Compare Two Possible Alternating Patterns
 Time Complexity: O(n)
 Space Complexity: O(1)
 ============================================================
"""

"""
 ------------------------------------------------------------
 💡 Core Idea

 A binary string is alternating if no two adjacent
 characters are the same.

 Possible alternating patterns:

 Pattern 1 → 010101...
 Pattern 2 → 101010...

 Strategy:

 Traverse the string and count mismatches for both patterns.

 zeroStartCount → mismatches when pattern starts with '0'
 oneStartCount  → mismatches when pattern starts with '1'

 The minimum of these two values gives the answer.
 ------------------------------------------------------------
"""


"""
 ============================================================
 ⚡ Approach : Pattern Comparison
 ------------------------------------------------------------
 Idea:

 For each index i:

 If i is EVEN:
    Pattern1 expects '0'
    Pattern2 expects '1'

 If i is ODD:
    Pattern1 expects '1'
    Pattern2 expects '0'

 Count mismatches for both patterns.

 Return the minimum operations required.

 Time Complexity:
 O(n)

 Space Complexity:
 O(1)
 ============================================================
"""


class Solution:
    def minOperations(self, s: str) -> int:

        zeroStartCount = 0
        oneStartCount = 0

        for i in range(len(s)):

            if i % 2 == 0:

                # Pattern starting with '0'
                if s[i] == '1':
                    zeroStartCount += 1

                # Pattern starting with '1'
                if s[i] == '0':
                    oneStartCount += 1

            else:

                # Pattern starting with '0'
                if s[i] == '0':
                    zeroStartCount += 1

                # Pattern starting with '1'
                if s[i] == '1':
                    oneStartCount += 1

        return min(zeroStartCount, oneStartCount)
